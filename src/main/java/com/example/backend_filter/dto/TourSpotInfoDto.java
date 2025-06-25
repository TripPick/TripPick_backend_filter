package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.backend_filter.entity.TourSpotInfo; // TourSpotInfo 엔티티 import
import java.time.LocalDateTime;

@Schema(description = "관광지 정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourSpotInfoDto {

    @Schema(description = "콘텐츠 ID")
    private String contentid;

    @Schema(description = "수용 인원")
    private String accomcount;

    @Schema(description = "유모차 대여 여부")
    private String chkbabycarriage;

    @Schema(description = "신용카드 사용 가능 여부")
    private String chkcreditcard;

    @Schema(description = "반려동물 동반 가능 여부")
    private String chkpet;

    @Schema(description = "체험 가능 연령")
    private String expagerange;

    @Schema(description = "체험 안내")
    private String expguide;

    @Schema(description = "세계 문화 유산 유무")
    private String heritage1;

    @Schema(description = "세계 자연 유산 유무")
    private String heritage2;

    @Schema(description = "세계 기록 유산 유무")
    private String heritage3;

    @Schema(description = "문의 및 안내")
    private String infocenter;

    @Schema(description = "개장일")
    private LocalDateTime opendate;

    @Schema(description = "주차 시설")
    private String parking;

    @Schema(description = "쉬는 날")
    private String restdate;

    @Schema(description = "이용 계절")
    private String useseason;

    @Schema(description = "이용 시간")
    private String usetime;

    // TourSpotInfo 엔티티를 DTO로 변환하는 정적 팩토리 메서드 추가
    public static TourSpotInfoDto fromEntity(TourSpotInfo entity) {
        return TourSpotInfoDto.builder()
                .contentid(entity.getContentid())
                .accomcount(entity.getAccomcount())
                .chkbabycarriage(entity.getChkbabycarriage())
                .chkcreditcard(entity.getChkcreditcard())
                .chkpet(entity.getChkpet())
                .expagerange(entity.getExpagerange())
                .expguide(entity.getExpguide())
                .heritage1(entity.getHeritage1())
                .heritage2(entity.getHeritage2())
                .heritage3(entity.getHeritage3())
                .infocenter(entity.getInfocenter())
                .opendate(entity.getOpendate())
                .parking(entity.getParking())
                .restdate(entity.getRestdate())
                .useseason(entity.getUseseason())
                .usetime(entity.getUsetime())
                .build();
    }
}
