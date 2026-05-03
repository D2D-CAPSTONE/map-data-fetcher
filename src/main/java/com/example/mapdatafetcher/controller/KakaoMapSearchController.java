package com.example.mapdatafetcher.controller;

import com.example.mapdatafetcher.dto.ErrorResponse;
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
@Tag(name = "Kakao Map", description = "Kakao Map search API")
public class KakaoMapSearchController {

  private final KakaoMapSearchService kakaoMapSearchService;

  public KakaoMapSearchController(KakaoMapSearchService kakaoMapSearchService) {
    this.kakaoMapSearchService = kakaoMapSearchService;
  }

  @Operation(
      summary = "Search Kakao Map places",
      description = "Returns raw Kakao Map place results for the given query and page number.")
  @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Search completed successfully",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = Object.class)),
                examples =
                    @ExampleObject(
                        value =
                            "[{\"confirmid\":\"16590379\",\"name\":\"풍미연\",\"address\":\"서울 노원구 상계동 323-11\",\"new_address\":\"서울 노원구 노해로85길 7\",\"lat\":37.6556909,\"lon\":127.06482209,\"last_cate_name\":\"설렁탕\",\"reviewCount\":241,\"rating_average\":3.2,\"img\":\"http://t1.daumcdn.net/local/kakaomapPhoto/review/ad20fa578eafba8d3709a3059aba28aa75e3eed0?original\"},{\"confirmid\":\"26086942\",\"name\":\"털보고된이 본점\",\"address\":\"서울 노원구 상계동 332-3 1층\",\"new_address\":\"서울 노원구 노해로81길 22-22\",\"lat\":37.65589329,\"lon\":127.06376607,\"last_cate_name\":\"해물,생선\",\"reviewCount\":263,\"rating_average\":4.3,\"img\":\"http://t1.daumcdn.net/local/kakaomapPhoto/review/ff425c1be1553b625c301b5134c13be36b1eb390?original\"}]"))),
    @ApiResponse(
        responseCode = "400",
        description = "Invalid query parameters",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ValidationErrorResponse.class))),
    @ApiResponse(
        responseCode = "502",
        description = "Failed to call Kakao Map provider",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponse.class)))
  })
  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public JsonNode search(@Valid @ParameterObject @ModelAttribute KakaoMapSearchRequest request) {
    return kakaoMapSearchService.search(request);
  }
}
