package com.example.backend_filter.repository;

import com.example.backend_filter.entity.CulturalFacilityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturalFacilityInfoRepository extends JpaRepository<CulturalFacilityInfo, String> {
}
