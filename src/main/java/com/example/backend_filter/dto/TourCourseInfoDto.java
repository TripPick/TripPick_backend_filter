package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.backend_filter.entity.TourCourseInfo; // TourCourseInfo 엔티티 import

@Schema(description = "여행 코스 정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourCourseInfoDto {

    @Schema(description = "콘텐츠 ID")
    private String contentId;

    @Schema(description = "코스 총 거리")
    private String distance;

    @Schema(description = "여행 코스 문의 및 안내")
    private String infocentertourcourse;

    @Schema(description = "코스 일정")
    private String schedule;

    @Schema(description = "코스 소요 시간")
    private String taketime;

    @Schema(description = "코스 테마")
    private String theme;

    // TourCourseInfo 엔티티를 DTO로 변환하는 정적 팩토리 메서드 추가
    public static TourCourseInfoDto fromEntity(TourCourseInfo entity) {
        return TourCourseInfoDto.builder()
                .contentId(entity.getContentId())
                .distance(entity.getDistance())
                .infocentertourcourse(entity.getInfocentertourcourse())
                .schedule(entity.getSchedule())
                .taketime(entity.getTaketime())
                .theme(entity.getTheme())
                .build();
    }
}
