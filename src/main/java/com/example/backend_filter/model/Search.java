package com.example.backend_filter.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "search")
@Data
public class Search {
    @Id // contentId를 기본 키로 지정합니다.
    @Column(name = "content_id", length = 255, nullable = false) // VARCHAR(255)로 변경, NOT NULL 유지
    private String contentId;

    // 기존 id 필드는 삭제됩니다.

    @Column(name = "content_type", length = 2)
    private String contentType;

    @Column(name = "cat1", length = 20)
    private String cat1;

    @Column(name = "cat2", length = 20)
    private String cat2;

    @Column(name = "cat3", length = 20)
    private String cat3;

    @Column(name = "area_code", length = 20)
    private String areaCode;

    @Column(name = "addr1", columnDefinition = "TEXT")
    private String addr1;

    @Column(name = "addr2", columnDefinition = "TEXT")
    private String addr2;

    @Column(name = "firstimage", columnDefinition = "TEXT")
    private String firstimage;

    @Column(name = "firstimage2", columnDefinition = "TEXT")
    private String firstimage2;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "l_dong_regn_cd", length = 10)
    private String lDongRegnCd;

    @Column(name = "l_dong_sigungu_cd", length = 10)
    private String lDongSigunguCd;

    @Column(name = "event_start_date")
    private LocalDate eventStartDate;

    @Column(name = "event_end_date")
    private LocalDate eventEndDate;

    @Column(name = "modified_time")
    private LocalDateTime modifiedTime;
}