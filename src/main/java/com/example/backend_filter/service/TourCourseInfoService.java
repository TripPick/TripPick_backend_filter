package com.example.backend_filter.service;

import com.example.backend_filter.dto.TourCourseInfoDto;
import com.example.backend_filter.repository.TourCourseInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourCourseInfoService {

    @Autowired
    private TourCourseInfoRepository tourCourseInfoRepository;

    public List<TourCourseInfoDto> getAllTourCourses() {
        return tourCourseInfoRepository.findAll().stream()
                .map(TourCourseInfoDto::fromEntity) // DTO에서 변환 처리하도록 수정
                .collect(Collectors.toList());
    }

    public Optional<TourCourseInfoDto> getTourCourseById(String contentId) {
        return tourCourseInfoRepository.findById(contentId)
                .map(TourCourseInfoDto::fromEntity); // DTO에서 변환 처리하도록 수정
    }
}
