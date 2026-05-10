package com.example.mapdatafetcher.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ErrorResponse", description = "에러 응답")
public record ErrorResponse(
    @Schema(description = "에러 메시지", example = "요청 처리에 실패했습니다") String message,
    @Schema(description = "상세 에러 내용", example = "외부 API 응답을 정상적으로 받지 못했습니다") String detail) {}
