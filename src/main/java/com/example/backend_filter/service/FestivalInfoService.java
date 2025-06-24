package com.example.backend_filter.service;

import com.example.backend_filter.dto.FestivalInfoDto;
import com.example.backend_filter.repository.FestivalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FestivalInfoService {

    @Autowired
    private FestivalInfoRepository festivalInfoRepository;

    public List<FestivalInfoDto> getAllFestivals() {
        return festivalInfoRepository.findAll().stream()
                .map(FestivalInfoDto::fromEntity) // DTO에서 변환 처리하도록 수정
                .collect(Collectors.toList());
    }

    public Optional<FestivalInfoDto> getFestivalById(String contentId) {
        return festivalInfoRepository.findById(contentId)
                .map(FestivalInfoDto::fromEntity); // DTO에서 변환 처리하도록 수정
    }
}
