package com.example.backend_filter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistration;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // API Gateway에서 CORS를 처리하므로 주석 처리
    /*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns(
                        "http://localhost:3000",    // React 기본 포트
                        "http://localhost:5173",    // Vite 기본 포트
                        "http://localhost:5174",    // Vite 대체 포트
                        "http://localhost:5175",    // Vite 대체 포트
                        "http://localhost:5176",    // Vite 대체 포트
                        "http://localhost:8080",    // 일반적인 개발 포트
                        "http://localhost:8081",    // 대체 포트
                        "http://localhost:8082",    // 대체 포트
                        "http://localhost:8083",    // 대체 포트
                        "http://localhost:8084",    // 대체 포트
                        "http://localhost:8085"     // 현재 Backend 포트
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                // 허용할 헤더 설정
                .allowedHeaders("*")
                // 인증 정보 포함 허용 (쿠키, Authorization 헤더 등)
                .allowCredentials(true)
                // Preflight 요청의 캐시 시간 설정 (초 단위)
                .maxAge(3600);
    }
    */
}
