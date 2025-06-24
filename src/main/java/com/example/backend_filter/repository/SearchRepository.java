package com.example.backend_filter.repository;

import com.example.backend_filter.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search, String>, JpaSpecificationExecutor<Search> {

    // 모든 고유한 대분류 (cat1) 조회
    @Query("SELECT DISTINCT s.cat1 FROM Search s WHERE s.cat1 IS NOT NULL AND s.cat1 != ''")
    List<String> findDistinctCat1();

    // 특정 대분류 (cat1)에 속하는 고유한 중분류 (cat2) 조회
    @Query("SELECT DISTINCT s.cat2 FROM Search s WHERE s.cat1 = ?1 AND s.cat2 IS NOT NULL AND s.cat2 != ''")
    List<String> findDistinctCat2ByCat1(String cat1);

    // 특정 대분류 (cat1)와 중분류 (cat2)에 속하는 고유한 소분류 (cat3) 조회
    @Query("SELECT DISTINCT s.cat3 FROM Search s WHERE s.cat1 = ?1 AND s.cat2 = ?2 AND s.cat3 IS NOT NULL AND s.cat3 != ''")
    List<String> findDistinctCat3ByCat1AndCat2(String cat1, String cat2);

    // 모든 고유한 법정동 시도 코드 (lDongRegnCd) 조회
    @Query("SELECT DISTINCT s.lDongRegnCd FROM Search s WHERE s.lDongRegnCd IS NOT NULL AND s.lDongRegnCd != ''")
    List<String> findDistinctLDongRegnCd();

    // 특정 법정동 시도 코드 (lDongRegnCd)에 속하는 고유한 법정동 시군구 코드 (lDongSignguCd) 조회
    @Query("SELECT DISTINCT s.lDongSignguCd FROM Search s WHERE s.lDongRegnCd = ?1 AND s.lDongSignguCd IS NOT NULL AND s.lDongSignguCd != ''")
    List<String> findDistinctLDongSigunguCdByLDongRegnCd(String lDongRegnCd);
}
