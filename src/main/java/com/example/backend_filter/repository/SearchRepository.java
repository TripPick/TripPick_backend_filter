package com.example.backend_filter.repository;

import com.example.backend_filter.model.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

// JpaRepository<엔티티 타입, 기본 키 타입>
public interface SearchRepository extends JpaRepository<Search, String>, JpaSpecificationExecutor<Search> { // ★ 기본 키 타입이 Long에서 String으로 변경! ★

    // --- 필터 드롭다운 옵션 조회를 위한 DISTINCT 쿼리 ---
    @Query("SELECT DISTINCT s.cat1 FROM Search s WHERE s.cat1 IS NOT NULL AND s.cat1 <> '' ORDER BY s.cat1")
    List<String> findDistinctCat1();

    @Query("SELECT DISTINCT s.cat2 FROM Search s WHERE s.cat1 = :cat1 AND s.cat2 IS NOT NULL AND s.cat2 <> '' ORDER BY s.cat2")
    List<String> findDistinctCat2ByCat1(String cat1);

    @Query("SELECT DISTINCT s.cat3 FROM Search s WHERE s.cat1 = :cat1 AND s.cat2 = :cat2 AND s.cat3 IS NOT NULL AND s.cat3 <> '' ORDER BY s.cat3")
    List<String> findDistinctCat3ByCat1AndCat2(String cat1, String cat2);

    @Query("SELECT DISTINCT s.lDongRegnCd FROM Search s WHERE s.lDongRegnCd IS NOT NULL AND s.lDongRegnCd <> '' ORDER BY s.lDongRegnCd")
    List<String> findDistinctLDongRegnCd();

    @Query("SELECT DISTINCT s.lDongSigunguCd FROM Search s WHERE s.lDongRegnCd = :lDongRegnCd AND s.lDongSigunguCd IS NOT NULL AND s.lDongSigunguCd <> '' ORDER BY s.lDongSigunguCd")
    List<String> findDistinctLDongSigunguCdByLDongRegnCd(String lDongRegnCd);
}