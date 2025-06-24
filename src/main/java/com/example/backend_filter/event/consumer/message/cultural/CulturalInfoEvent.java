package com.example.backend_filter.event.consumer.message.cultural;

import com.example.backend_filter.entity.CulturalFacilityInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CulturalInfoEvent {
    public static final String Topic = "culturalinfo";

    private String action;

    private CulturalFacilityInfo culturalFacilityInfo;

    public static CulturalInfoEvent fromEntity(String action, CulturalFacilityInfo culturalFacilityInfo){
        CulturalInfoEvent message = new CulturalInfoEvent();

        message.action = action;
        message.culturalFacilityInfo = culturalFacilityInfo;

        return message;
    }
}
