package com.example.kakaomapdatafetcher.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
@EnableConfigurationProperties({
        KakaoMapClientProperties.class,
        NaverMapSeleniumProperties.class
})
public class KakaoMapClientConfig {

    @Bean
    RestClient kakaoMapRestClient(RestClient.Builder builder, KakaoMapClientProperties properties) {
        return builder
                .baseUrl(properties.baseUrl())
                .defaultHeader(HttpHeaders.REFERER, properties.referer())
                .defaultHeader(HttpHeaders.USER_AGENT, properties.userAgent())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
