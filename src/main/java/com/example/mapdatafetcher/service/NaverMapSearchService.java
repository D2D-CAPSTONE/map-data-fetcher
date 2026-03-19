package com.example.mapdatafetcher.service;

import com.example.mapdatafetcher.config.NaverMapSeleniumProperties;
import com.example.mapdatafetcher.dto.NaverMapSearchRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

@Service
public class NaverMapSearchService {

  private final ObjectMapper objectMapper;
  private final NaverMapSeleniumProperties properties;

  public NaverMapSearchService(ObjectMapper objectMapper, NaverMapSeleniumProperties properties) {
    this.objectMapper = objectMapper;
    this.properties = properties;
  }

  public JsonNode search(NaverMapSearchRequest request) {
    ChromeDriver driver = createDriver();
    try {
      driver.executeCdpCommand("Network.enable", Map.of());
      driver.get(
          properties.searchUrl() + UriUtils.encodePathSegment(request.q(), StandardCharsets.UTF_8));

      JsonNode firstPageResponse =
          objectMapper.readTree(waitForSearchResponseBody(driver, properties.responseUrlKeyword()));
      if (request.page() <= 1) {
        return firstPageResponse;
      }

      switchToSearchIframe(driver);
      return navigateToPageAndCaptureGraphql(driver, request.page());
    } catch (Exception exception) {
      throw new IllegalStateException("Failed to capture Naver map search response", exception);
    } finally {
      driver.quit();
    }
  }

  private ChromeDriver createDriver() {
    ChromeOptions options = new ChromeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    options.addArguments("--disable-gpu", "--start-maximized");

    if (properties.headless()) {
      options.addArguments("--headless=new");
    }

    LoggingPreferences loggingPreferences = new LoggingPreferences();
    loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
    options.setCapability("goog:loggingPrefs", loggingPreferences);

    ChromeDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    return driver;
  }

  private JsonNode navigateToPageAndCaptureGraphql(ChromeDriver driver, int targetPage)
      throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, properties.timeout());
    By paginationContainerSelector = By.xpath("//*[@id='app-root']/div/div[2]/div[2]");
    By pageButtonSelector =
        By.xpath("//*[@id='app-root']/div/div[2]/div[2]/a[normalize-space(text()) != '']");

    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(paginationContainerSelector));
    } catch (TimeoutException exception) {
      throw new IllegalStateException("Pagination bar did not appear", exception);
    }

    Optional<WebElement> targetButton = findPageButton(driver, targetPage, pageButtonSelector);
    if (targetButton.isEmpty()) {
      throw new IllegalStateException("Requested page button not found: " + targetPage);
    }

    clearPerformanceLogs(driver);
    Thread.sleep(300L);
    WebElement clickableButton;
    try {
      clickableButton = wait.until(ExpectedConditions.elementToBeClickable(targetButton.get()));
    } catch (TimeoutException exception) {
      throw new IllegalStateException(
          "Target page button was not clickable: " + targetPage, exception);
    }

    clickableButton.click();
    Thread.sleep(300L);
    try {
      wait.until(
          driverInstance ->
              findSelectedPageButton(driverInstance, pageButtonSelector)
                  .map(button -> String.valueOf(targetPage).equals(button.getText().trim()))
                  .orElse(false));
    } catch (TimeoutException exception) {
      throw new IllegalStateException(
          "Page selection did not change after click: " + targetPage, exception);
    }

    return objectMapper.readTree(
        waitForSearchResponseBody(driver, properties.graphqlResponseUrlKeyword()));
  }

  private void switchToSearchIframe(ChromeDriver driver) {
    driver.switchTo().defaultContent();
    WebDriverWait wait = new WebDriverWait(driver, properties.timeout());
    wait.until(
        ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#searchIframe")));
  }

  private Optional<WebElement> findPageButton(
      WebDriver driver, int targetPage, By pageButtonSelector) {
    return driver.findElements(pageButtonSelector).stream()
        .filter(element -> String.valueOf(targetPage).equals(element.getText().trim()))
        .findFirst();
  }

  private Optional<WebElement> findSelectedPageButton(WebDriver driver, By pageButtonSelector) {
    return driver.findElements(pageButtonSelector).stream()
        .filter(
            element -> {
              String className = element.getAttribute("class");
              String ariaCurrent = element.getAttribute("aria-current");
              return (className != null && className.contains("qxokY"))
                  || "page".equalsIgnoreCase(ariaCurrent);
            })
        .findFirst();
  }

  private void clearPerformanceLogs(ChromeDriver driver) {
    driver.manage().logs().get(LogType.PERFORMANCE);
  }

  private String waitForSearchResponseBody(ChromeDriver driver, String responseUrlKeyword)
      throws Exception {
    Instant deadline = Instant.now().plus(properties.timeout());

    while (Instant.now().isBefore(deadline)) {
      LogEntries entries = driver.manage().logs().get(LogType.PERFORMANCE);
      List<LogEntry> logs = entries.getAll();
      for (LogEntry entry : logs) {
        JsonNode message = objectMapper.readTree(entry.getMessage()).path("message");
        String method = message.path("method").asText();
        if (!"Network.responseReceived".equals(method)) {
          continue;
        }

        JsonNode params = message.path("params");
        String url = params.path("response").path("url").asText();
        if (!url.contains(responseUrlKeyword)) {
          continue;
        }

        String requestId = params.path("requestId").asText();
        Map<String, Object> bodyResult;
        try {
          bodyResult =
              driver.executeCdpCommand("Network.getResponseBody", Map.of("requestId", requestId));
        } catch (WebDriverException ignored) {
          continue;
        }
        Object body = bodyResult.get("body");
        if (!(body instanceof String bodyText)) {
          break;
        }

        if (Boolean.TRUE.equals(bodyResult.get("base64Encoded"))) {
          return new String(Base64.getDecoder().decode(bodyText), StandardCharsets.UTF_8);
        }

        return bodyText;
      }

      Thread.sleep(200L);
    }

    throw new TimeoutException("Timed out while waiting for Naver search response");
  }
}
