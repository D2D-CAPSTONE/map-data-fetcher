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
import java.util.logging.Level;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
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

      String responseBody = waitForSearchResponseBody(driver);
      return objectMapper.readTree(responseBody);
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

  private String waitForSearchResponseBody(ChromeDriver driver) throws Exception {
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
        if (!url.contains(properties.responseUrlKeyword())) {
          continue;
        }

        String requestId = params.path("requestId").asText();
        Map<String, Object> bodyResult =
            driver.executeCdpCommand("Network.getResponseBody", Map.of("requestId", requestId));
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
