package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "검색 및 필터링 조건")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchFilterDto {

    @Schema(description = "콘텐츠 타입 ID", example = "12")
    private String contentTypeId;

    @Schema(description = "대분류 카테고리", example = "A01")
    private String cat1;

    @Schema(description = "중분류 카테고리", example = "A0101")
    private String cat2;

    @Schema(description = "소분류 카테고리", example = "A01010500")
    private String cat3;

    @Schema(description = "법정동 시도 코드", example = "26")
    private String lDongRegnCd;

    @Schema(description = "법정동 시군구 코드", example = "380")
    private String lDongSigunguCd;

    @Schema(description = "지역 코드", example = "6")
    private String areaCode;

    @Schema(description = "제목 검색어", example = "낙동강")
    private String title;
}
