package com.example.backend_filter.repository;

import com.example.backend_filter.entity.FestivalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalInfoRepository extends JpaRepository<FestivalInfo, String> {
}
