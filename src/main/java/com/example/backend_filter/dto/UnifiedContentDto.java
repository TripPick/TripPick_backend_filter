package com.example.backend_filter.dto;

import com.example.backend_filter.entity.Search;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "통합 콘텐츠 데이터 (검색 + 상세 정보)")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnifiedContentDto {

    // SearchDto 필드 (공통 정보)
    @Schema(description = "콘텐츠 고유 ID", example = "C1001")
    private String contentId;
    @Schema(description = "관광타입 ID", example = "12")
    private String contentTypeId; // DTO 필드 이름을 contentTypeId로 통일
    @Schema(description = "대분류 카테고리", example = "자연")
    private String cat1;
    @Schema(description = "중분류 카테고리", example = "자연관광지")
    private String cat2;
    @Schema(description = "소분류 카테고리", example = "국립공원")
    private String cat3;
    @Schema(description = "지역 코드", example = "42")
    private String areaCode;
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
    @Schema(description = "우편번호", example = "12345")
    private String zipcode;
    @Schema(description = "콘텐츠 최종 수정 시간", example = "2024-01-20T10:30:00")
    private LocalDateTime modifiedtime; // String으로 유지 (엔티티 필드와 동일)
    @Schema(description = "콘텐츠 생성 시간", example = "2024-01-20T10:30:00")
    private LocalDateTime createdtime; // String으로 유지 (엔티티 필드와 동일)
    @Schema(description = "법정동 시도 코드", example = "42")
    private String lDongRegnCd;
    @Schema(description = "법정동 시군구 코드", example = "42230")
    private String lDongSigunguCd;


    // 상세 정보 DTO 필드 (해당하는 경우에만 채워짐)
    @Schema(description = "관광지 상세 정보")
    private TourSpotInfoDto tourSpotInfo;

    @Schema(description = "문화 시설 상세 정보")
    private CulturalFacilityInfoDto culturalFacilityInfo;

    @Schema(description = "축제/공연 행사 상세 정보")
    private FestivalInfoDto festivalInfo;

    @Schema(description = "여행 코스 상세 정보")
    private TourCourseInfoDto tourCourseInfo;

    // Search 엔티티와 상세 DTO를 통합 DTO로 변환하는 정적 팩토리 메서드
    public static UnifiedContentDto fromSearchAndDetails(Search searchEntity,
                                                         TourSpotInfoDto tourSpotInfo,
                                                         CulturalFacilityInfoDto culturalFacilityInfo,
                                                         FestivalInfoDto festivalInfo,
                                                         TourCourseInfoDto tourCourseInfo) {

        SearchDto searchDto = SearchDto.fromEntity(searchEntity);

        return UnifiedContentDto.builder()
                .contentId(searchDto.getContentid())
                .contentTypeId(searchDto.getContenttypeid())
                .cat1(searchDto.getCat1())
                .cat2(searchDto.getCat2())
                .cat3(searchDto.getCat3())
                .areaCode(searchDto.getAreacode())
                .addr1(searchDto.getAddr1())
                .addr2(searchDto.getAddr2())
                .firstimage(searchDto.getFirstimage())
                .firstimage2(searchDto.getFirstimage2())
                .tel(searchDto.getTel())
                .title(searchDto.getTitle())
                .zipcode(searchDto.getZipcode())
                .modifiedtime(searchDto.getModifiedtime())
                .createdtime(searchDto.getCreatedtime())
                .lDongRegnCd(searchDto.getLDongRegnCd())
                .lDongSigunguCd(searchDto.getLDongSigunguCd())
                .tourSpotInfo(tourSpotInfo)
                .culturalFacilityInfo(culturalFacilityInfo)
                .festivalInfo(festivalInfo)
                .tourCourseInfo(tourCourseInfo)
                .build();
    }
}
