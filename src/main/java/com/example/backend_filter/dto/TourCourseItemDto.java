package com.example.backend_filter.dto;

import com.example.backend_filter.entity.TourCourseInfo;
import com.example.backend_filter.entity.TourCourseItem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "여행 코스")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourCourseItemDto {

    @Schema(description ="콘텐츠ID")
    private String contentid;

    @Schema(description ="하위콘텐츠ID")
    private String subcontentid;

    @Schema(description ="코스이미지설명")
    private String subdetailalt;

    @Schema(description ="코스이미지")
    private String subdetailimg;

    @Schema(description ="코스개요")
    private String subdetailoverview;

    @Schema(description ="코스명")
    private String subname;

    @Schema(description ="반복일련번호")
    private String subnum;

    public static TourCourseItemDto fromEntity(TourCourseItem entity) {
        return TourCourseItemDto.builder()
                .contentid(entity.getContentid())
                .subcontentid(entity.getSubcontentid())
                .subdetailalt(entity.getSubdetailalt())
                .subdetailimg(entity.getSubdetailimg())
                .subdetailoverview(entity.getSubdetailoverview())
                .subname(entity.getSubname())
                .subnum(entity.getSubnum())
                .build();
    }
}
