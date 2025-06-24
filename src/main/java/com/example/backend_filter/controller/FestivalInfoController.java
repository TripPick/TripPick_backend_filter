package com.example.backend_filter.controller;

import com.example.backend_filter.common.dto.ApiResponseDto;
import com.example.backend_filter.dto.FestivalInfoDto;
import com.example.backend_filter.service.FestivalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/festivals")
public class FestivalInfoController {

    @Autowired
    private FestivalInfoService festivalInfoService;

    @GetMapping
    public ResponseEntity<ApiResponseDto<List<FestivalInfoDto>>> getAllFestivals() {
        List<FestivalInfoDto> festivals = festivalInfoService.getAllFestivals();
        return ResponseEntity.ok(ApiResponseDto.createOk(festivals));
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ApiResponseDto<FestivalInfoDto>> getFestivalById(@PathVariable String contentId) {
        return festivalInfoService.getFestivalById(contentId)
                .map(festivalInfoDTO -> ResponseEntity.ok(ApiResponseDto.createOk(festivalInfoDTO)))
                .orElse(ResponseEntity.notFound().build());
    }
}
