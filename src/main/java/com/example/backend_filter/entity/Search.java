package com.example.backend_filter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime; // modifiedTime과 createdTime이 LocalDateTime이 될 수 있으므로 추가

@Entity
@Table(name = "Search") // 데이터베이스 테이블 이름과 일치
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Search {

    @Id
    @Column(name = "content_id", length = 20, nullable = false)
    private String contentId;

    @Column(name = "content_type_id", length = 2)
    private String contentTypeId;

    @Column(name = "cat1", length = 20)
    private String cat1;

    @Column(name = "cat2", length = 20)
    private String cat2;

    @Column(name = "cat3", length = 20)
    private String cat3;

    @Column(name = "lDong_signgu_cd")
    private String lDongSignguCd;

    @Column(name = "lDong_regn_cd")
    private String lDongRegnCd;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "addr1", columnDefinition = "TEXT")
    private String addr1;

    @Column(name = "addr2", columnDefinition = "TEXT")
    private String addr2;

    @Column(name = "first_image", columnDefinition = "TEXT")
    private String firstImage;

    @Column(name = "first_image2", columnDefinition = "TEXT")
    private String firstImage2;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "zipcode", length = 5)
    private String zipcode;

    @Column(name = "modified_time")
    private String modifiedTime;

    @Column(name = "created_time")
    private String createdTime;
}
