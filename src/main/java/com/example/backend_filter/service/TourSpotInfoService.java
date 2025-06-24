package com.example.backend_filter.service;

import com.example.backend_filter.dto.TourSpotInfoDto;
import com.example.backend_filter.repository.TourSpotInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourSpotInfoService {

    @Autowired
    private TourSpotInfoRepository tourSpotInfoRepository;

    public List<TourSpotInfoDto> getAllTourSpots() {
        return tourSpotInfoRepository.findAll().stream()
                .map(TourSpotInfoDto::fromEntity) // DTO에서 변환 처리하도록 수정
                .collect(Collectors.toList());
    }

    public Optional<TourSpotInfoDto> getTourSpotById(String contentId) {
        return tourSpotInfoRepository.findById(contentId)
                .map(TourSpotInfoDto::fromEntity); // DTO에서 변환 처리하도록 수정
    }
}
