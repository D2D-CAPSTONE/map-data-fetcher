package com.example.mapdatafetcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "KakaoMapSearchRequest", description = "Kakao Map search request")
public record KakaoMapSearchRequest(
    @Schema(
            description = "Search keyword",
            example = "gangnam station",
            requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "q is required")
        String q,
    @Schema(
            description = "Result page number",
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
