package com.example.backend_filter.service;

import com.example.backend_filter.dto.TourCourseItemDto;
import com.example.backend_filter.repository.TourCourseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourCourseItemService {

    @Autowired
    private TourCourseItemRepository tourCourseItemRepository;

    public List<TourCourseItemDto> getAllTourItems() {
        return tourCourseItemRepository.findAll().stream()
                .map(TourCourseItemDto::fromEntity) // DTO에서 변환 처리하도록 수정
                .collect(Collectors.toList());
    }

    public Optional<TourCourseItemDto> getTourCourseById(String contentId) {
        return tourCourseItemRepository.findById(contentId)
                .map(TourCourseItemDto::fromEntity); // DTO에서 변환 처리하도록 수정
    }
}
