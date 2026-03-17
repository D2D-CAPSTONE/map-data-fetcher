package com.example.kakaomapdatafetcher.controller;

import com.example.kakaomapdatafetcher.dto.KakaoMapSearchRequest;
import com.example.kakaomapdatafetcher.service.KakaoMapSearchService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kakao-map")
public class KakaoMapSearchController {

    private final KakaoMapSearchService kakaoMapSearchService;

    public KakaoMapSearchController(KakaoMapSearchService kakaoMapSearchService) {
        this.kakaoMapSearchService = kakaoMapSearchService;
    }

    @GetMapping("/search")
    public JsonNode search(@Valid @ModelAttribute KakaoMapSearchRequest request) {
        return kakaoMapSearchService.search(request);
    }
}
