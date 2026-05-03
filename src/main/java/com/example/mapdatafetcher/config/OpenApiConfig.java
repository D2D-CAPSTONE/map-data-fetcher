package com.example.mapdatafetcher.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI mapDataFetcherOpenApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("지도 데이터 수집 API")
                .description("카카오맵과 네이버맵 검색 결과를 조회하는 API 문서")
                .version("v1"));
  }
}
