package com.example.backend_filter.controller;

import com.example.backend_filter.dto.SearchDto;
import com.example.backend_filter.dto.SearchFilterRequest;
import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.service.SearchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid; // @Valid 어노테이션 사용
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "여행지 검색 API", description = "여행지 정보 조회 및 필터링")
@RestController
@RequestMapping("/api")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @Operation(summary = "여행지 목록 조회 및 필터링", description = "다양한 조건으로 여행지 목록을 조회합니다.") // ★ API 설명 ★
    @ApiResponses(value = { // ★ 응답 설명 ★
            @ApiResponse(responseCode = "200", description = "성공적으로 여행지 목록을 조회했습니다.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 파라미터입니다.")
    })
    @GetMapping("/contents")
    public ApiResponseDto<List<SearchDto>> searchContents(
            @ModelAttribute SearchFilterRequest filterRequest) {
        List<SearchDto> responseList = searchService.searchContents(filterRequest);
        return ApiResponseDto.createOk(responseList);
    }

    @Operation(summary = "특정 여행지 상세 조회", description = "contentId를 이용하여 단일 여행지의 상세 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공적으로 여행지 상세 정보를 조회했습니다."),
            @ApiResponse(responseCode = "404", description = "해당 contentId의 여행지를 찾을 수 없습니다.")
    })
    @GetMapping("/contents/{contentId}")
    public ApiResponseDto<SearchDto> getContentById(@PathVariable String contentId) {
        SearchDto response = searchService.getContentById(contentId);
        return ApiResponseDto.createOk(response);
    }

    @Operation(summary = "대분류(cat1) 목록 조회", description = "모든 대분류 카테고리 목록을 조회합니다.")
    @GetMapping("/cat1")
    public ApiResponseDto<List<String>> getDistinctCat1() {
        List<String> categories = searchService.getDistinctCat1();
        return ApiResponseDto.createOk(categories);
    }

    @Operation(summary = "중분류(cat2) 목록 조회", description = "특정 대분류(cat1)에 해당하는 중분류 카테고리 목록을 조회합니다.")
    @GetMapping("/cat2")
    public ApiResponseDto<List<String>> getDistinctCat2ByCat1(@RequestParam String cat1) {
        List<String> categories = searchService.getDistinctCat2ByCat1(cat1);
        return ApiResponseDto.createOk(categories);
    }

    @Operation(summary = "소분류(cat3) 목록 조회", description = "특정 대분류(cat1)와 중분류(cat2)에 해당하는 소분류 카테고리 목록을 조회합니다.")
    @GetMapping("/cat3")
    public ApiResponseDto<List<String>> getDistinctCat3ByCat1AndCat2(
            @RequestParam String cat1,
            @RequestParam String cat2) {
        List<String> categories = searchService.getDistinctCat3ByCat1AndCat2(cat1, cat2);
        return ApiResponseDto.createOk(categories);
    }

    @Operation(summary = "법정동 시도 코드(lDongRegnCd) 목록 조회", description = "모든 법정동 시도 코드 목록을 조회합니다.")
    @GetMapping("/regn-cd")
    public ApiResponseDto<List<String>> getDistinctLDongRegnCd() {
        List<String> regnCodes = searchService.getDistinctLDongRegnCd();
        return ApiResponseDto.createOk(regnCodes);
    }
    @Operation(summary = "법정동 시군구 코드(lDongSigunguCd) 목록 조회", description = "특정 법정동 시도 코드(lDongRegnCd)에 해당하는 시군구 코드 목록을 조회합니다.")
    @GetMapping("/sigungu-cd")
    public ApiResponseDto<List<String>> getDistinctLDongSigunguCdByLDongRegnCd(@RequestParam String lDongRegnCd) {
        List<String> sigunguCodes = searchService.getDistinctLDongSigunguCdByLDongRegnCd(lDongRegnCd);
        return ApiResponseDto.createOk(sigunguCodes);
    }

}