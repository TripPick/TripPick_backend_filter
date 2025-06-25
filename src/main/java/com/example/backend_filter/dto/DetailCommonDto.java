package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.backend_filter.entity.DetailCommon; // 엔티티 클래스 import
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "여행지 콘텐츠 데이터")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommonDto {

    @Schema(description = "콘텐츠 ID")
    private String contentid;
    @Schema(description = "관광타입 ID (12:관광지, 14:문화시설 등)")
    private String contenttypeid;
    @Schema(description = "지역코드")
    private String areacode;
    @Schema(description = "주소 (예: 서울 중구 다동)")
    private String addr1;
    @Schema(description = "상세주소")

    private String addr2;
    @Schema(description = "원본 대표 이미지 URL (약 500*333 size)")
    private String firstimage;
    @Schema(description = "썸네일 대표 이미지 URL (약 150*100 size)")
    private String firstimage2;
    @Schema(description = "전화번호")
    private String tel;
    @Schema(description = "콘텐츠 제목")
    private String title;
    @Schema(description = "우편번호")
    private String zipcode;
    @Schema(description = "최초 등록일")
    private String createdtime;
    @Schema(description = "콘텐츠 수정일")
    private String modifiedtime;

    public static DetailCommonDto fromEntity(DetailCommon entity) {
        return DetailCommonDto.builder()
                .contentid(entity.getContentid())
                .contenttypeid(entity.getContenttypeid())
                .areacode(entity.getAreacode())
                .addr1(entity.getAddr1())
                .addr2(entity.getAddr2())
                .firstimage(entity.getFirstImage())
                .firstimage2(entity.getFirstImage2())
                .tel(entity.getTel())
                .title(entity.getTitle())
                .zipcode(entity.getZipcode())
                .createdtime(entity.getCreatedTime())
                .modifiedtime(entity.getModifiedTime())
                .build();
    }
}
