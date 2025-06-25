package com.example.backend_filter.event.consumer.message.courseitem;

import com.example.backend_filter.entity.TourCourseItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseItemEvent {
    public static final String Topic = "tourcourseitem";

    private String action;

    private TourCourseItem tourCourseItem;

    public static CourseItemEvent fromEntity(String action, TourCourseItem tourCourseItem) {
        CourseItemEvent message = new CourseItemEvent();
        message.action = action;
        message.tourCourseItem = tourCourseItem;
        return message;
    }
}
