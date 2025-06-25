package com.example.backend_filter.event.consumer.message.event;

import com.example.backend_filter.entity.FestivalInfo;
import com.example.backend_filter.entity.TourSpotInfo;
import com.example.backend_filter.event.consumer.message.spot.SpotInfoEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventInfoEvent {
    public static final String Topic = "festivalinfo";

    private String action;

    private FestivalInfo festivalInfo;

    public static EventInfoEvent fromEntity(String action, FestivalInfo festivalInfo){
        EventInfoEvent message = new EventInfoEvent();

        message.action = action;
        message.festivalInfo = festivalInfo;

        return message;
    }
}
