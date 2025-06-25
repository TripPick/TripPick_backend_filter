package com.example.backend_filter.controller;

import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.dto.RandomSearchDto;
import com.example.backend_filter.dto.SearchDto;
import com.example.backend_filter.dto.SearchFilterDto;
import com.example.backend_filter.dto.UnifiedContentDto; // UnifiedContentDto import
import com.example.backend_filter.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<SearchDto>>> getAllSearches() {
        List<SearchDto> searches = searchService.getAllSearches();
        return ResponseEntity.ok(ApiResponseDto.createOk(searches));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponseDto<SearchDto>> getSearchById(@PathVariable String contentId) {
        return searchService.getSearchById(contentId)
                .map(searchDto -> ResponseEntity.ok(ApiResponseDto.createOk(searchDto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponseDto<List<UnifiedContentDto>>> getFilteredSearches(@ModelAttribute SearchFilterDto filters) {
        List<UnifiedContentDto> filteredSearches = searchService.getFilteredSearches(filters);
        return ResponseEntity.ok(ApiResponseDto.createOk(filteredSearches));
    }

    @GetMapping("/random")
    public ResponseEntity<ApiResponseDto<List<RandomSearchDto>>> getRandomSearchesByContentTypeId(
            @RequestParam String contentTypeId,
            @RequestParam(defaultValue = "4") int limit) { // Default to 4 if not specified
        // Service now returns List<RandomSearchResponseDto>
        List<RandomSearchDto> randomSearches = searchService.getRandomSearchesByContentTypeId(contentTypeId, limit);
        return ResponseEntity.ok(ApiResponseDto.createOk(randomSearches));
    }

    @GetMapping("/options/cat1")
    public ResponseEntity<ApiResponseDto<List<String>>> getCat1Options() {
        List<String> options = searchService.getAvailableCat1Options();
        return ResponseEntity.ok(ApiResponseDto.createOk(options));
    }

    @GetMapping("/options/cat2")
    public ResponseEntity<ApiResponseDto<List<String>>> getCat2Options(@RequestParam(required = false) String cat1) {
        List<String> options = searchService.getAvailableCat2Options(cat1);
        return ResponseEntity.ok(ApiResponseDto.createOk(options));
    }

    @GetMapping("/options/cat3")
    public ResponseEntity<ApiResponseDto<List<String>>> getCat3Options(
            @RequestParam(required = false) String cat1,
            @RequestParam(required = false) String cat2) {
        List<String> options = searchService.getAvailableCat3Options(cat1, cat2);
        return ResponseEntity.ok(ApiResponseDto.createOk(options));
    }

    @GetMapping("/options/ldongregncd")
    public ResponseEntity<ApiResponseDto<List<String>>> getLDongRegnCdOptions() {
        List<String> options = searchService.getAvailableLDongRegnCdOptions();
        return ResponseEntity.ok(ApiResponseDto.createOk(options));
    }

    @GetMapping("/options/ldongsigungucd")
    public ResponseEntity<ApiResponseDto<List<String>>> getLDongSigunguCdOptions(@RequestParam(required = false) String lDongRegnCd) {
        List<String> options = searchService.getAvailableLDongSigunguCdOptions(lDongRegnCd);
        return ResponseEntity.ok(ApiResponseDto.createOk(options));
    }
}
