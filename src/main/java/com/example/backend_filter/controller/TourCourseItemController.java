package com.example.backend_filter.controller;

import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.dto.TourCourseItemDto;
import com.example.backend_filter.service.TourCourseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/touritems")
public class TourCourseItemController {

    @Autowired
    private TourCourseItemService tourCourseItemService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<TourCourseItemDto>>> getAllTourItems() {
        List<TourCourseItemDto> tourCourses = tourCourseItemService.getAllTourItems();
        return ResponseEntity.ok(ApiResponseDto.createOk(tourCourses));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponseDto<TourCourseItemDto>> getTourCourseById(@PathVariable String contentId) {
        return tourCourseItemService.getTourCourseById(contentId)
                .map(tourCourseItemDTO -> ResponseEntity.ok(ApiResponseDto.createOk(tourCourseItemDTO)))
                .orElse(ResponseEntity.notFound().build());
    }
}
