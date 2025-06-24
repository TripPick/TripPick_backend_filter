package com.example.backend_filter.event.consumer.message.spot;

import com.example.backend_filter.entity.DetailCommon;
import com.example.backend_filter.entity.TourSpotInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpotInfoEvent {
    public static final String Topic = "spotinfo";

    private String action;

    private TourSpotInfo tourSpotInfo;

    public static SpotInfoEvent fromEntity(String action, TourSpotInfo tourSpotInfo){
        SpotInfoEvent message = new SpotInfoEvent();

        message.action = action;
        message.tourSpotInfo = tourSpotInfo;

        return message;
    }
}
