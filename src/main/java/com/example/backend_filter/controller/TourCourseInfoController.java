package com.example.backend_filter.controller;

import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.dto.TourCourseInfoDto;
import com.example.backend_filter.service.TourCourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tourcourses")
public class TourCourseInfoController {

    @Autowired
    private TourCourseInfoService tourCourseInfoService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<TourCourseInfoDto>>> getAllTourCourses() {
        List<TourCourseInfoDto> tourCourses = tourCourseInfoService.getAllTourCourses();
        return ResponseEntity.ok(ApiResponseDto.createOk(tourCourses));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponseDto<TourCourseInfoDto>> getTourCourseById(@PathVariable String contentId) {
        return tourCourseInfoService.getTourCourseById(contentId)
                .map(tourCourseInfoDTO -> ResponseEntity.ok(ApiResponseDto.createOk(tourCourseInfoDTO)))
                .orElse(ResponseEntity.notFound().build());
    }
}
