package com.example.backend_filter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tour_course_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourCourseInfo {

    @Id
    @Column(name = "contentId")
    private String contentId;

    @Column(name = "distance", length = 225)
    private String distance;

    @Column(name = "infocentertourcourse", length = 225)
    private String infocentertourcourse;

    @Column(name = "schedule", length = 225)
    private String schedule;

    @Column(name = "taketime", length = 225)
    private String taketime;

    @Column(name = "theme", length = 225)
    private String theme;

}