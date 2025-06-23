package com.example.backend_filter.dto;

import com.example.backend_filter.model.Search;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "여행지 콘텐츠 데이터")
public class SearchDto {
    @Schema(description = "콘텐츠 고유 ID", example = "C1001")
    private String contentId;

    @Schema(description = "관광타입 ID", example = "12")
    private String contentType;
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
    @Schema(description = "법정동 시도 코드", example = "42")
    private String lDongRegnCd;
    @Schema(description = "법정동 시군구 코드", example = "42230")
    private String lDongSigunguCd;
    @Schema(description = "행사 시작일", example = "2025-06-01")
    private LocalDate eventStartDate;
    @Schema(description = "행사 종료일", example = "2025-06-10")
    private LocalDate eventEndDate;
    @Schema(description = "콘텐츠 최종 수정 시간", example = "2024-01-20T10:30:00")
    private LocalDateTime modifiedTime;

    public SearchDto(Search search) {
        this.contentId = search.getContentId();

        this.contentType = search.getContentType();
        this.cat1 = search.getCat1();
        this.cat2 = search.getCat2();
        this.cat3 = search.getCat3();
        this.areaCode = search.getAreaCode();
        this.addr1 = search.getAddr1();
        this.addr2 = search.getAddr2();
        this.firstimage = search.getFirstimage();
        this.firstimage2 = search.getFirstimage2();
        this.tel = search.getTel();
        this.title = search.getTitle();
        this.lDongRegnCd = search.getLDongRegnCd();
        this.lDongSigunguCd = search.getLDongSigunguCd();
        this.eventStartDate = search.getEventStartDate();
        this.eventEndDate = search.getEventEndDate();
        this.modifiedTime = search.getModifiedTime();
    }

    public Search toEntity() {
        Search search = new Search();
        search.setContentId(this.contentId);
        search.setContentType(this.contentType);
        search.setCat1(this.cat1);
        search.setCat2(this.cat2);
        search.setCat3(this.cat3);
        search.setAreaCode(this.areaCode);
        search.setAddr1(this.addr1);
        search.setAddr2(this.addr2);
        search.setFirstimage(this.firstimage);
        search.setFirstimage2(this.firstimage2);
        search.setTel(this.tel);
        search.setTitle(this.title);
        search.setLDongRegnCd(this.lDongRegnCd);
        search.setLDongSigunguCd(this.lDongSigunguCd);
        search.setEventStartDate(this.eventStartDate);
        search.setEventEndDate(this.eventEndDate);
        search.setModifiedTime(LocalDateTime.now());

        return search;
    }
}