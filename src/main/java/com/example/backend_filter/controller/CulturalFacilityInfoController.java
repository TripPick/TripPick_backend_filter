package com.example.backend_filter.controller;

import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.dto.CulturalFacilityInfoDto;
import com.example.backend_filter.service.CulturalFacilityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/culturalfacilities")
public class CulturalFacilityInfoController {

    @Autowired
    private CulturalFacilityInfoService culturalFacilityInfoService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<CulturalFacilityInfoDto>>> getAllCulturalFacilities() {
        List<CulturalFacilityInfoDto> facilities = culturalFacilityInfoService.getAllCulturalFacilities();
        return ResponseEntity.ok(ApiResponseDto.createOk(facilities));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponseDto<CulturalFacilityInfoDto>> getCulturalFacilityById(@PathVariable String contentId) {
        return culturalFacilityInfoService.getCulturalFacilityById(contentId)
                .map(culturalFacilityInfoDTO -> ResponseEntity.ok(ApiResponseDto.createOk(culturalFacilityInfoDTO)))
                .orElse(ResponseEntity.notFound().build());
    }
}
