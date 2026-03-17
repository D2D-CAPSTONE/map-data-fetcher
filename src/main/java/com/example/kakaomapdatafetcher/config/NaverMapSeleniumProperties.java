package com.example.kakaomapdatafetcher.config;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "naver.map.selenium")
public record NaverMapSeleniumProperties(
        String searchUrl,
        String responseUrlKeyword,
        boolean headless,
        Duration timeout
) {
}
