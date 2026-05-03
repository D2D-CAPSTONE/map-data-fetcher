package com.example.mapdatafetcher.service;

import com.example.mapdatafetcher.config.KakaoMapClientProperties;
import com.example.mapdatafetcher.dto.KakaoLocalKeywordSearchRequest;
import com.example.mapdatafetcher.dto.KakaoMapSearchRequest;
import com.example.mapdatafetcher.exception.AppConfigurationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class KakaoMapSearchService {

  private final RestClient kakaoMapRestClient;
  private final RestClient kakaoLocalRestClient;
  private final KakaoMapClientProperties kakaoMapClientProperties;

  public KakaoMapSearchService(
      @Qualifier("kakaoMapRestClient") RestClient kakaoMapRestClient,
      @Qualifier("kakaoLocalRestClient") RestClient kakaoLocalRestClient,
      KakaoMapClientProperties kakaoMapClientProperties) {
    this.kakaoMapRestClient = kakaoMapRestClient;
    this.kakaoLocalRestClient = kakaoLocalRestClient;
    this.kakaoMapClientProperties = kakaoMapClientProperties;
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

  public JsonNode searchLocalKeyword(KakaoLocalKeywordSearchRequest request) {
    if (!StringUtils.hasText(kakaoMapClientProperties.restApiKey())) {
      throw new AppConfigurationException("KAKAO_REST_API_KEY is not configured");
    }

    JsonNode response =
        kakaoLocalRestClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .path("/v2/local/search/keyword.json")
                        .queryParam("query", request.query())
                        .queryParam("x", request.x())
                        .queryParam("y", request.y())
                        .queryParamIfPresent("radius", Optional.ofNullable(request.radius()))
                        .queryParam("page", request.page())
                        .queryParam("size", request.size())
                        .queryParam("sort", request.sort())
                        .build())
            .header(HttpHeaders.AUTHORIZATION, "KakaoAK " + kakaoMapClientProperties.restApiKey())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(JsonNode.class);

    if (response == null) {
      return JsonNodeFactory.instance.objectNode();
    }

    return response;
  }
}
