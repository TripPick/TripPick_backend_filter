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
@Table(name = "search") // 데이터베이스 테이블 이름과 일치
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Search {

    @Id
    @Column(name = "contentid", length = 20)
    private String contentid;

    @Column(name = "contenttypeid", length = 2)
    private String contentTypeid;

    @Column(name = "cat1")
    private String cat1;

    @Column(name = "cat2")
    private String cat2;

    @Column(name = "cat3")
    private String cat3;

    @Column(name = "l_dong_signgu_cd")
    private String lDongSignguCd;

    @Column(name = "l_dong_regn_cd")
    private String lDongRegnCd;

    @Column(name = "areacode")
    private String areacode;

    @Column(name = "addr1")
    private String addr1;

    @Column(name = "addr2")
    private String addr2;

    @Column(name = "firstimage")
    private String firstimage;

    @Column(name = "firstimage2")
    private String firstimage2;

    @Column(name = "tel")
    private String tel;

    @Column(name = "title")
    private String title;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "modifiedtime")
    private LocalDateTime modifiedtime;

    @Column(name = "createdtime")
    private LocalDateTime createdtime;
}
