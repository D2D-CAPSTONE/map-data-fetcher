package com.example.mapdatafetcher.controller;

import com.example.mapdatafetcher.dto.ErrorResponse;
import com.example.mapdatafetcher.dto.KakaoLocalKeywordSearchRequest;
import com.example.mapdatafetcher.dto.KakaoMapSearchRequest;
import com.example.mapdatafetcher.dto.ValidationErrorResponse;
import com.example.mapdatafetcher.service.KakaoMapSearchService;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kakao-map")
@Tag(name = "카카오맵", description = "카카오맵 검색 API")
public class KakaoMapSearchController {

  private final KakaoMapSearchService kakaoMapSearchService;

  public KakaoMapSearchController(KakaoMapSearchService kakaoMapSearchService) {
    this.kakaoMapSearchService = kakaoMapSearchService;
  }

  @Operation(summary = "카카오맵 검색", description = "검색어와 페이지 번호로 카카오맵 검색 결과 원본 데이터를 조회합니다.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "검색에 성공했습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = Object.class)),
                examples =
                    @ExampleObject(
                        value =
                            "[{\"confirmid\":\"16590379\",\"name\":\"홍대수제버거\",\"address\":\"서울 노원구 상계동 323-11\",\"new_address\":\"서울 노원구 노해로85길 7\",\"lat\":37.6556909,\"lon\":127.06482209,\"last_cate_name\":\"햄버거\",\"reviewCount\":241,\"rating_average\":3.2,\"img\":\"http://t1.daumcdn.net/local/kakaomapPhoto/review/ad20fa578eafba8d3709a3059aba28aa75e3eed0?original\"},{\"confirmid\":\"26086942\",\"name\":\"미도참치 노원본점\",\"address\":\"서울 노원구 상계동 332-3 1층\",\"new_address\":\"서울 노원구 노해로81길 22-22\",\"lat\":37.65589329,\"lon\":127.06376607,\"last_cate_name\":\"일식,생선회\",\"reviewCount\":263,\"rating_average\":4.3,\"img\":\"http://t1.daumcdn.net/local/kakaomapPhoto/review/ff425c1be1553b625c301b5134c13be36b1eb390?original\"}]"))),
    @ApiResponse(
        responseCode = "400",
        description = "요청 파라미터가 올바르지 않습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ValidationErrorResponse.class))),
    @ApiResponse(
        responseCode = "502",
        description = "카카오맵 외부 호출에 실패했습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponse.class)))
  })
  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public JsonNode search(@Valid @ParameterObject @ModelAttribute KakaoMapSearchRequest request) {
    return kakaoMapSearchService.search(request);
  }

  @Operation(
      summary = "좌표 기준 카카오 장소 검색",
      description = "검색어와 중심 좌표(경도, 위도)를 기준으로 카카오 로컬 키워드 검색 API를 호출합니다.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "좌표 기반 검색에 성공했습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = Object.class),
                examples =
                    @ExampleObject(
                        value =
                            "{\"meta\":{\"pageable_count\":14,\"total_count\":14,\"is_end\":true},\"documents\":[{\"id\":\"26338954\",\"place_name\":\"카카오프렌즈 코엑스점\",\"distance\":\"418\",\"place_url\":\"http://place.map.kakao.com/26338954\",\"category_name\":\"가정,생활 > 문구,사무용품 > 디자인문구 > 카카오프렌즈\",\"address_name\":\"서울 강남구 삼성동 159\",\"road_address_name\":\"서울 강남구 영동대로 513\",\"phone\":\"02-6002-1880\",\"x\":\"127.05902969025047\",\"y\":\"37.51207412593136\"}]}"))),
    @ApiResponse(
        responseCode = "400",
        description = "요청 파라미터가 올바르지 않습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ValidationErrorResponse.class))),
    @ApiResponse(
        responseCode = "500",
        description = "카카오 REST API 키가 설정되어 있지 않습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponse.class))),
    @ApiResponse(
        responseCode = "502",
        description = "카카오 로컬 API 호출에 실패했습니다",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponse.class)))
  })
  @GetMapping(value = "/coordinate", produces = MediaType.APPLICATION_JSON_VALUE)
  public JsonNode searchLocalKeyword(
      @Valid @ParameterObject @ModelAttribute KakaoLocalKeywordSearchRequest request) {
    return kakaoMapSearchService.searchLocalKeyword(request);
  }
}
