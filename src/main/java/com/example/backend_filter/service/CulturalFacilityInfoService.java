package com.example.backend_filter.service;

import com.example.backend_filter.dto.CulturalFacilityInfoDto;
import com.example.backend_filter.repository.CulturalFacilityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CulturalFacilityInfoService {

    @Autowired
    private CulturalFacilityInfoRepository culturalFacilityInfoRepository;

    public List<CulturalFacilityInfoDto> getAllCulturalFacilities() {
        return culturalFacilityInfoRepository.findAll().stream()
                .map(CulturalFacilityInfoDto::fromEntity) // DTO에서 변환 처리하도록 수정
                .collect(Collectors.toList());
    }

    public Optional<CulturalFacilityInfoDto> getCulturalFacilityById(String contentId) {
        return culturalFacilityInfoRepository.findById(contentId)
                .map(CulturalFacilityInfoDto::fromEntity); // DTO에서 변환 처리하도록 수정
    }
}
