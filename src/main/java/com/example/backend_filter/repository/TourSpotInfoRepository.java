package com.example.backend_filter.repository;

import com.example.backend_filter.entity.TourSpotInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourSpotInfoRepository extends JpaRepository<TourSpotInfo, String> {
}
