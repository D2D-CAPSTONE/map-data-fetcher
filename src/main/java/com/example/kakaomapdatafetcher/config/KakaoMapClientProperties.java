package com.example.kakaomapdatafetcher.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kakao.map.client")
public record KakaoMapClientProperties(
        String baseUrl,
        String referer,
        String userAgent
) {
}
