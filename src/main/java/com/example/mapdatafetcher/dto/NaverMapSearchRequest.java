package com.example.mapdatafetcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "NaverMapSearchRequest", description = "Naver Map search request")
public record NaverMapSearchRequest(
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
            maximum = "5")
        @Min(value = 1, message = "page must be at least 1")
        @Max(value = 5, message = "page must be at most 5")
        Integer page) {
  public NaverMapSearchRequest {
    page = page == null ? 1 : page;
  }
}
