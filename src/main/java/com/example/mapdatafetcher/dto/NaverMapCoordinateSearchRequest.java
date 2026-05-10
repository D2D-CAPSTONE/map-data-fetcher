package com.example.mapdatafetcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(name = "NaverMapCoordinateSearchRequest", description = "네이버맵 위치 기반 키워드 검색 요청")
public record NaverMapCoordinateSearchRequest(
    @Schema(description = "검색어", example = "카페", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "query is required")
        String query,
    @Schema(
            description = "중심 좌표 경도(longitude)",
            example = "127.105649",
            requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "x is required") @DecimalMin(value = "-180.0", message = "x must be at least -180")
        @DecimalMax(value = "180.0", message = "x must be at most 180")
        Double x,
    @Schema(
            description = "중심 좌표 위도(latitude)",
            example = "37.64349",
            requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "y is required") @DecimalMin(value = "-90.0", message = "y must be at least -90")
        @DecimalMax(value = "90.0", message = "y must be at most 90")
        Double y,
    @Schema(
            description = "결과 페이지 번호",
            example = "1",
            defaultValue = "1",
            minimum = "1",
            maximum = "5")
        @Min(value = 1, message = "page must be at least 1")
        @Max(value = 5, message = "page must be at most 5")
        Integer page) {
  public NaverMapCoordinateSearchRequest {
    page = page == null ? 1 : page;
  }
}
