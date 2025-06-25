package com.example.backend_filter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.backend_filter.entity.CulturalFacilityInfo; // CulturalFacilityInfo 엔티티 import

@Schema(description = "문화 시설 정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CulturalFacilityInfoDto {

    @Schema(description = "콘텐츠 ID")
    private String contentid;

    @Schema(description = "수용 인원")
    private String accomcountculture;

    @Schema(description = "유모차 대여 여부")
    private String chkbabycarriageculture;

    @Schema(description = "신용카드 사용 가능 여부")
    private String chkcreditcardculture;

    @Schema(description = "반려동물 동반 가능 여부")
    private String chkpetculture;

    @Schema(description = "할인 정보")
    private String discountinfo;

    @Schema(description = "문의 및 안내 전화번호")
    private String infocenterculture;

    @Schema(description = "주차 시설 여부")
    private String parkingculture;

    @Schema(description = "주차 요금")
    private String parkingfee;

    @Schema(description = "쉬는 날")
    private String restdateculture;

    @Schema(description = "이용 요금")
    private String usefee;

    @Schema(description = "이용 시간")
    private String usetimeculture;

    @Schema(description = "규모")
    private String scale;

    @Schema(description = "관람 소요 시간")
    private String spendtime;

    public static CulturalFacilityInfoDto fromEntity(CulturalFacilityInfo entity) {
        return CulturalFacilityInfoDto.builder()
                .contentid(entity.getContentid())
                .accomcountculture(entity.getAccomcountculture())
                .chkbabycarriageculture(entity.getChkbabycarriageculture())
                .chkcreditcardculture(entity.getChkcreditcardculture())
                .chkpetculture(entity.getChkpetculture())
                .discountinfo(entity.getDiscountinfo())
                .infocenterculture(entity.getInfocenterculture())
                .parkingculture(entity.getParkingculture())
                .parkingfee(entity.getParkingfee())
                .restdateculture(entity.getRestdateculture())
                .usefee(entity.getUsefee())
                .usetimeculture(entity.getUsetimeculture())
                .scale(entity.getScale())
                .spendtime(entity.getSpendtime())
                .build();
    }
}
