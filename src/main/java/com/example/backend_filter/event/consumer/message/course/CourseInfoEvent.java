package com.example.backend_filter.event.consumer.message.course;

import com.example.backend_filter.entity.TourCourseInfo;
import com.example.backend_filter.entity.TourSpotInfo;
import com.example.backend_filter.event.consumer.message.spot.SpotInfoEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseInfoEvent {
    public static final String Topic = "courseinfo";

    private String action;

    private TourCourseInfo tourCourseInfo;

    public static CourseInfoEvent fromEntity(String action, TourCourseInfo tourCourseInfo){
        CourseInfoEvent message = new CourseInfoEvent();

        message.action = action;
        message.tourCourseInfo = tourCourseInfo;

        return message;
    }
}
