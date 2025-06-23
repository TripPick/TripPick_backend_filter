package com.example.backend_filter;

import com.example.backend_filter.model.Search;
import com.example.backend_filter.repository.SearchRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate; // LocalDate 임포트
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final SearchRepository searchRepository;

    @PostConstruct
    public void initData() {
        // 데이터가 이미 존재하는지 확인 (contentId를 PK로 사용하므로 count()가 더 정확)
        if (searchRepository.count() > 0) {
            System.out.println("데이터가 이미 존재하므로 초기 데이터를 삽입하지 않습니다.");
            return;
        }

        System.out.println("MariaDB 'search' 테이블에 초기 데이터를 삽입합니다...");

        // 예시 데이터 (contentId는 고유해야 합니다!)
        searchRepository.saveAll(List.of(
                createSearch("C1001", "12", "자연", "자연관광지", "국립공원", "42", "강원특별자치도 속초시 설악산로", "설악동", "https://placehold.co/500x333/007bff/fff?text=Seoraksan", "https://placehold.co/150x100/007bff/fff?text=SeoraksanThumb", "033-636-7700", "설악산 국립공원", "42", "42230", null, null), // eventDate 없음
                createSearch("C1002", "12", "자연", "자연관광지", "해수욕장", "26", "부산광역시 해운대구 우동", "해운대해변로", "https://placehold.co/500x333/28a745/fff?text=Haeundae", "https://placehold.co/150x100/28a745/fff?text=HaeundaeThumb", "051-749-4082", "해운대 해수욕장", "26", "26350", null, null),
                createSearch("C1003", "14", "문화", "박물관", "국립박물관", "11", "서울특별시 용산구 서빙고로", "국립중앙박물관", "https://placehold.co/500x333/ffc107/333?text=NationalMuseum", "https://placehold.co/150x100/ffc107/333?text=NationalMuseumThumb", "02-2077-9000", "국립중앙박물관", "11", "11170", null, null),
                createSearch("C1004", "15", "문화", "축제", "지역축제", "42", "강원특별자치도 강릉시", "강릉 단오제 행사장", "https://placehold.co/500x333/008080/fff?text=Danoje", "https://placehold.co/150x100/008080/fff?text=DanojeThumb", "033-660-3944", "강릉 단오제", "42", "42150", LocalDate.of(2025, 6, 1), LocalDate.of(2025, 6, 10)), // 행사 기간
                createSearch("C1005", "28", "레저", "스키/보드", "스키장", "42", "강원특별자치도 평창군 대관령면 올림픽로", "용평리조트", "https://placehold.co/500x333/dc3545/fff?text=Yongpyong", "https://placehold.co/150x100/dc3545/fff?text=YongpyongThumb", "033-335-5757", "용평리조트 스키장", "42", "42760", null, null),
                createSearch("C1006", "12", "자연", "자연관광지", "국립공원", "50", "제주특별자치도 제주시 1100로", "한라산 국립공원", "https://placehold.co/500x333/0099ff/fff?text=Hallasan", "https://placehold.co/150x100/0099ff/fff?text=HallasanThumb", "064-713-9950", "한라산 국립공원", "50", "50110", null, null),
                createSearch("C1007", "25", "문화", "유적지", "사찰", "47", "경상북도 경주시 불국로", "불국사", "https://placehold.co/500x333/9933ff/fff?text=Bulguksa", "https://placehold.co/150x100/9933ff/fff?text=BulguksaThumb", "054-746-9950", "불국사", "47", "47130", null, null),
                createSearch("C1008", "15", "레저", "테마파크", "워터파크", "42", "강원특별자치도 홍천군 서면 한치골길", "비발디파크 오션월드", "https://placehold.co/500x333/00bcd4/fff?text=OceanWorld", "https://placehold.co/150x100/00bcd4/fff?text=OceanWorldThumb", "1588-4888", "오션월드", "42", "42820", LocalDate.of(2025, 7, 1), LocalDate.of(2025, 8, 31)) // 행사 기간
        ));

        System.out.println("MariaDB 'search' 테이블에 초기 데이터 삽입 완료!");
    }

    // 초기 데이터 생성을 위한 헬퍼 메서드 (필드명 변경 반영)
    private Search createSearch(String contentId, String contentType, String cat1, String cat2, String cat3,
                                String areaCode, String addr1, String addr2, String firstimage, String firstimage2, String tel,
                                String title, String lDongRegnCd, String lDongSigunguCd, LocalDate eventStartDate, LocalDate eventEndDate) {
        Search search = new Search();
        search.setContentId(contentId);
        search.setContentType(contentType);
        search.setCat1(cat1);
        search.setCat2(cat2);
        search.setCat3(cat3);
        search.setAreaCode(areaCode);
        search.setAddr1(addr1);
        search.setAddr2(addr2);
        search.setFirstimage(firstimage);
        search.setFirstimage2(firstimage2);
        search.setTel(tel);
        search.setTitle(title);
        search.setLDongRegnCd(lDongRegnCd);
        search.setLDongSigunguCd(lDongSigunguCd);
        search.setEventStartDate(eventStartDate);
        search.setEventEndDate(eventEndDate);
        search.setModifiedTime(LocalDateTime.now().minusDays((long)(Math.random() * 365))); // 현재 시간 기준 랜덤 수정일
        return search;
    }
}