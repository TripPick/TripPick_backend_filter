package com.example.backend_filter.controller;

import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.dto.TourSpotInfoDto;
import com.example.backend_filter.service.TourSpotInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tourspots")
public class TourSpotInfoController {

    @Autowired
    private TourSpotInfoService tourSpotInfoService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<TourSpotInfoDto>>> getAllTourSpots() {
        List<TourSpotInfoDto> tourSpots = tourSpotInfoService.getAllTourSpots();
        return ResponseEntity.ok(ApiResponseDto.createOk(tourSpots));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponseDto<TourSpotInfoDto>> getTourSpotById(@PathVariable String contentId) {
        return tourSpotInfoService.getTourSpotById(contentId)
                .map(tourSpotInfoDTO -> ResponseEntity.ok(ApiResponseDto.createOk(tourSpotInfoDTO)))
                .orElse(ResponseEntity.notFound().build());
    }
}
