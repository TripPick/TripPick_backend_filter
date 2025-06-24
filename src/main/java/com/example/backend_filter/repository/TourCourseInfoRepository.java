package com.example.backend_filter.repository;

import com.example.backend_filter.entity.TourCourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourCourseInfoRepository extends JpaRepository<TourCourseInfo, String> {
}
