package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "메인 페이지 랜덤 데이터")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RandomSearchDto {
    private String contentid;

    private String title;

    private String addr1;

    private String firstimage2;

    public static RandomSearchDto fromUnifiedContentDto(UnifiedContentDto unifiedContentDto) {
        return RandomSearchDto.builder()
                .contentid(unifiedContentDto.getContentid())
                .title(unifiedContentDto.getTitle())
                .addr1(unifiedContentDto.getAddr1())
                .firstimage2(unifiedContentDto.getFirstimage2())
                .build();
    }
}