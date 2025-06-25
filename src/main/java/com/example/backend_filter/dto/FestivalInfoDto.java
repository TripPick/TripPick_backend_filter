package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.backend_filter.entity.FestivalInfo; // FestivalInfo 엔티티 import

@Schema(description = "축제 및 공연 행사 정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FestivalInfoDto {

    @Schema(description = "콘텐츠 ID")
    private String contentid;

    @Schema(description = "연령 제한")
    private String agelimit;

    @Schema(description = "예매처")
    private String bookingplace;

    @Schema(description = "축제 할인 정보")
    private String discountinfofestival;

    @Schema(description = "행사 종료일")
    private String eventenddate;

    @Schema(description = "행사 홈페이지")
    private String eventhomepage;

    @Schema(description = "행사 장소")
    private String eventplace;

    @Schema(description = "행사 시작일")
    private String eventstartdate;

    @Schema(description = "장소 정보")
    private String placeinfo;

    @Schema(description = "공연 시간")
    private String playtime;

    @Schema(description = "프로그램 정보")
    private String program;

    @Schema(description = "축제 소요 시간")
    private String spendtimefestival;

    @Schema(description = "주최자1")
    private String sponsor1;

    @Schema(description = "주최자1 연락처")
    private String sponsor1tel;

    @Schema(description = "주최자2")
    private String sponsor2;

    @Schema(description = "주최자2 연락처")
    private String sponsor2tel;

    @Schema(description = "부대 행사")
    private String subevent;

    @Schema(description = "축제 이용 시간")
    private String usetimefestival;

    public static FestivalInfoDto fromEntity(FestivalInfo entity) {
        return FestivalInfoDto.builder()
                .contentid(entity.getContentid())
                .agelimit(entity.getAgelimit())
                .bookingplace(entity.getBookingplace())
                .discountinfofestival(entity.getDiscountinfofestival())
                .eventenddate(entity.getEventenddate())
                .eventhomepage(entity.getEventhomepage())
                .eventplace(entity.getEventplace())
                .eventstartdate(entity.getEventstartdate())
                .placeinfo(entity.getPlaceinfo())
                .playtime(entity.getPlaytime())
                .program(entity.getProgram())
                .spendtimefestival(entity.getSpendtimefestival())
                .sponsor1(entity.getSponsor1())
                .sponsor1tel(entity.getSponsor1tel())
                .sponsor2(entity.getSponsor2())
                .sponsor2tel(entity.getSponsor2tel())
                .subevent(entity.getSubevent())
                .usetimefestival(entity.getUsetimefestival())
                .build();
    }
}
