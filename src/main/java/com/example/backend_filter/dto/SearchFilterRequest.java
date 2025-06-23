package com.example.backend_filter.dto;

import lombok.Data; // Lombok 어노테이션: Getter, Setter, equals, hashCode, toString 자동 생성
import lombok.NoArgsConstructor; // Lombok 어노테이션: 기본 생성자 자동 생성
import org.springframework.format.annotation.DateTimeFormat; // 날짜 포맷팅을 위한 임포트
import java.time.LocalDate; // LocalDate 타입 임포트
import io.swagger.v3.oas.annotations.media.Schema; // ★ Schema 어노테이션 임포트 ★

@Data
@NoArgsConstructor
@Schema(description = "여행지 필터링 요청 DTO")
public class SearchFilterRequest {
    @Schema(description = "콘텐츠 타입", example = "12")
    private String contentType;
    @Schema(description = "대분류", example = "자연")
    private String cat1;
    @Schema(description = "중분류", example = "자연관광지")
    private String cat2;
    @Schema(description = "소분류", example = "국립공원")
    private String cat3;
    @Schema(description = "지역 코드", example = "42")
    private String areaCode;
    @Schema(description = "법정동 시도 코드", example = "42")
    private String lDongRegnCd;
    @Schema(description = "법정동 시군구 코드", example = "42230")
    private String lDongSigunguCd;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "행사 시작일", example = "2025-01-01")
    private LocalDate eventStartDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Schema(description = "행사 종료일", example = "2025-12-31")
    private LocalDate eventEndDate;

    @Schema(description = "검색 키워드", example = "단오제")
    private String keyword;
}