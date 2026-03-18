package com.example.mapdatafetcher.service;

import com.example.mapdatafetcher.dto.KakaoMapSearchRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class KakaoMapSearchService {

  private final RestClient kakaoMapRestClient;

  public KakaoMapSearchService(RestClient kakaoMapRestClient) {
    this.kakaoMapRestClient = kakaoMapRestClient;
  }

  public JsonNode search(KakaoMapSearchRequest request) {
    String uri =
        UriComponentsBuilder.fromPath("/mapsearch/map.daum")
            .queryParam("q", request.q())
            .queryParam("page", request.page())
            .build()
            .toUriString();

    JsonNode response =
        kakaoMapRestClient
            .get()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(JsonNode.class);

    if (response == null) {
      return JsonNodeFactory.instance.arrayNode();
    }

    JsonNode place = response.path("place");
    if (place.isArray()) {
      return place;
    }

    return JsonNodeFactory.instance.arrayNode();
  }
}
