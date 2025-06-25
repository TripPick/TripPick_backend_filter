package com.example.backend_filter.dto;

import com.example.backend_filter.entity.Search;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "여행지 콘텐츠 데이터")
@Data
@NoArgsConstructor
@AllArgsConstructor // AllArgsConstructor 추가
@Builder // Builder 추가
public class SearchDto {
    @Schema(description = "콘텐츠 고유 ID", example = "C1001")
    private String contentid;
    @Schema(description = "관광타입 ID", example = "12")
    private String contenttypeid; // contentTypeId로 변경될 필요가 있을 수 있음 (엔티티 기준)
    @Schema(description = "대분류 카테고리", example = "자연")
    private String cat1;
    @Schema(description = "중분류 카테고리", example = "자연관광지")
    private String cat2;
    @Schema(description = "소분류 카테고리", example = "국립공원")
    private String cat3;
    @Schema(description = "지역 코드", example = "42")
    private String areacode;
    @Schema(description = "주소", example = "강원특별자치도 속초시 설악산로")
    private String addr1;
    @Schema(description = "상세 주소", example = "설악동")
    private String addr2;
    @Schema(description = "원본 대표 이미지 URL", example = "https://example.com/image1.jpg")
    private String firstimage;
    @Schema(description = "썸네일 대표 이미지 URL", example = "https://example.com/thumb1.jpg")
    private String firstimage2;
    @Schema(description = "전화번호", example = "033-123-4567")
    private String tel;
    @Schema(description = "콘텐츠 제목", example = "설악산 국립공원")
    private String title;
    @Schema(description = "법정동 시도 코드", example = "42")
    private String lDongRegnCd;
    @Schema(description = "법정동 시군구 코드", example = "42230")
    private String lDongSigunguCd;
    @Schema(description = "콘텐츠 최종 수정 시간", example = "2024-01-20T10:30:00")
    private LocalDateTime modifiedtime;
    @Schema(description = "콘텐츠 생성 시간", example = "2024-01-20T10:30:00")
    private LocalDateTime createdtime;
    @Schema(description = "우편번호", example = "12345")
    private String zipcode;

    // Search 엔티티를 DTO로 변환하는 정적 팩토리 메서드 추가
    public static SearchDto fromEntity(Search entity) {
        return SearchDto.builder()
                .contentid(entity.getContentid())
                .contenttypeid(entity.getContentTypeid()) // 엔티티의 getContentTypeId()를 사용
                .cat1(entity.getCat1())
                .cat2(entity.getCat2())
                .cat3(entity.getCat3())
                .lDongSigunguCd(entity.getLDongSignguCd())
                .lDongRegnCd(entity.getLDongRegnCd())
                .areacode(entity.getAreacode())
                .addr1(entity.getAddr1())
                .addr2(entity.getAddr2())
                .firstimage(entity.getFirstimage())
                .firstimage2(entity.getFirstimage2())
                .tel(entity.getTel())
                .title(entity.getTitle())
                .zipcode(entity.getZipcode())
                .modifiedtime(entity.getModifiedtime())
                .createdtime(entity.getCreatedtime())
                .build();
    }
}
