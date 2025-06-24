package com.example.backend_filter.event.consumer.message.common;

import com.example.backend_filter.entity.DetailCommon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonInfoEvent {
    public static final String Topic = "commoninfo";

    private String action;

    private DetailCommon detailCommon;

    public static CommonInfoEvent fromEntity(String action, DetailCommon detailCommon){
        CommonInfoEvent message = new CommonInfoEvent();

        message.action = action;
        message.detailCommon = detailCommon;

        return message;
    }
}
