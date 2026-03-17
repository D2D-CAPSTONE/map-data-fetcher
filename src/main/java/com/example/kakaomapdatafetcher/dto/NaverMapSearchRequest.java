package com.example.kakaomapdatafetcher.dto;

import jakarta.validation.constraints.NotBlank;

public record NaverMapSearchRequest(
        @NotBlank(message = "q is required")
        String q
) {
}
