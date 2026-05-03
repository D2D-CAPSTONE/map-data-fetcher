package com.example.mapdatafetcher.controller;

import com.example.mapdatafetcher.dto.ErrorResponse;
import com.example.mapdatafetcher.dto.NaverMapSearchRequest;
import com.example.mapdatafetcher.dto.ValidationErrorResponse;
import com.example.mapdatafetcher.service.NaverMapSearchService;
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
@RequestMapping("/api/naver-map")
@Tag(name = "Naver Map", description = "Naver Map search API")
public class NaverMapSearchController {

  private final NaverMapSearchService naverMapSearchService;

  public NaverMapSearchController(NaverMapSearchService naverMapSearchService) {
    this.naverMapSearchService = naverMapSearchService;
  }

  @Operation(
      summary = "Search Naver Map places",
      description = "Returns raw Naver Map place results for the given query and page number.")
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
                            "[{\"id\":\"1225845295\",\"name\":\"파스타한끼 노원본점\",\"category\":\"스파게티,파스타전문\",\"roadAddress\":\"상계로5길 19 대광빌딩 1층 파스타한끼노원본점\",\"x\":\"127.0635998\",\"y\":\"37.6569760\",\"distance\":\"380m\",\"hasBooking\":true,\"hasNPay\":true,\"visitorReviewCount\":\"4,819\",\"imageUrl\":\"https://ldb-phinf.pstatic.net/20241128_37/1732779573101N4BfO_JPEG/%B0%A1%B0%D4%C0%CC%B9%CC%C1%F6_%BF%DC%BA%CE_01.jpg\",\"bookingUrl\":\"https://m.booking.naver.com/booking/6/bizes/967012/search\",\"newBusinessHours\":{\"status\":\"영업 중\",\"description\":\"21:00에 라스트오더\"}},{\"id\":\"2009662047\",\"name\":\"코지하우스 노원점\",\"category\":\"양식\",\"roadAddress\":\"동일로 1419 1층\",\"x\":\"127.0601125\",\"y\":\"37.6552875\",\"distance\":\"600m\",\"hasBooking\":null,\"hasNPay\":false,\"visitorReviewCount\":\"1,481\",\"imageUrl\":\"https://ldb-phinf.pstatic.net/20260219_231/1771466879338Dor9H_JPEG/KakaoTalk_20251229_111436052.jpg\",\"phone\":\"02-936-6683\",\"newOpening\":true,\"newBusinessHours\":{\"status\":\"브레이크타임\",\"description\":\"17:00에 영업 시작\"}}]"))),
    @ApiResponse(
        responseCode = "400",
        description = "Invalid query parameters",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ValidationErrorResponse.class))),
    @ApiResponse(
        responseCode = "502",
        description = "Failed to capture Naver Map provider response",
        content =
            @Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
                schema = @Schema(implementation = ErrorResponse.class)))
  })
  @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
  public JsonNode search(@Valid @ParameterObject @ModelAttribute NaverMapSearchRequest request) {
    return naverMapSearchService.search(request);
  }
}
