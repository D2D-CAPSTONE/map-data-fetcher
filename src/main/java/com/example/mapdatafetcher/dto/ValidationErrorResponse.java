package com.example.mapdatafetcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;

@Schema(name = "ValidationErrorResponse", description = "유효성 검증 에러 응답")
public record ValidationErrorResponse(
    @Schema(description = "에러 메시지", example = "잘못된 요청입니다") String message,
    @Schema(
            description = "필드별 유효성 검증 메시지",
            example = "{\"q\":\"q is required\",\"page\":\"page must be at least 1\"}")
        Map<String, String> errors) {}
