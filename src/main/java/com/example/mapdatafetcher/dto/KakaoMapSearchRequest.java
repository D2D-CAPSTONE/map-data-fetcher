package com.example.mapdatafetcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "KakaoMapSearchRequest", description = "카카오맵 검색 요청")
public record KakaoMapSearchRequest(
    @Schema(description = "검색어", example = "노원역 맛집", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "q is required")
        String q,
    @Schema(
            description = "결과 페이지 번호",
            example = "1",
            defaultValue = "1",
            minimum = "1",
            maximum = "500")
        @Min(value = 1, message = "page must be at least 1")
        @Max(value = 500, message = "page must be at most 500")
        Integer page) {
  public KakaoMapSearchRequest {
    page = page == null ? 1 : page;
  }
}
