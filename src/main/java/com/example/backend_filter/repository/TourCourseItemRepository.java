package com.example.backend_filter.repository;

import com.example.backend_filter.entity.TourCourseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourCourseItemRepository extends JpaRepository<TourCourseItem, String> {
}
