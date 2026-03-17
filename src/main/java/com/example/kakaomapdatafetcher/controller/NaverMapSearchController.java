package com.example.kakaomapdatafetcher.controller;

import com.example.kakaomapdatafetcher.dto.NaverMapSearchRequest;
import com.example.kakaomapdatafetcher.service.NaverMapSearchService;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/naver-map")
public class NaverMapSearchController {

    private final NaverMapSearchService naverMapSearchService;

    public NaverMapSearchController(NaverMapSearchService naverMapSearchService) {
        this.naverMapSearchService = naverMapSearchService;
    }

    @GetMapping("/search")
    public JsonNode search(@Valid @ModelAttribute NaverMapSearchRequest request) {
        return naverMapSearchService.search(request);
    }
}
