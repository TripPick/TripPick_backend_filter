package com.example.backend_filter.service;

import com.example.backend_filter.dto.*;
import com.example.backend_filter.entity.Search;
import com.example.backend_filter.repository.SearchRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private CulturalFacilityInfoService culturalFacilityInfoService;
    @Autowired
    private FestivalInfoService festivalInfoService;
    @Autowired
    private TourCourseInfoService tourCourseInfoService;
    @Autowired
    private TourSpotInfoService tourSpotInfoService;


    public List<SearchDto> getAllSearches() {
        return searchRepository.findAll().stream()
                .map(SearchDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<SearchDto> getSearchById(String contentId) {
        return searchRepository.findById(contentId)
                .map(SearchDto::fromEntity);
    }

    // 필터링된 검색 결과를 가져오고 상세 정보를 포함하여 반환하는 메서드
    public List<UnifiedContentDto> getFilteredSearches(SearchFilterDto filters) {
        Specification<Search> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(filters.getContentTypeId())) {
                predicates.add(criteriaBuilder.equal(root.get("contentTypeId"), filters.getContentTypeId()));
            }
            if (StringUtils.hasText(filters.getCat1())) {
                predicates.add(criteriaBuilder.equal(root.get("cat1"), filters.getCat1()));
                if (StringUtils.hasText(filters.getCat2())) {
                    predicates.add(criteriaBuilder.equal(root.get("cat2"), filters.getCat2()));
                    if (StringUtils.hasText(filters.getCat3())) {
                        predicates.add(criteriaBuilder.equal(root.get("cat3"), filters.getCat3()));
                    }
                }
            }
            if (StringUtils.hasText(filters.getLDongRegnCd())) {
                predicates.add(criteriaBuilder.equal(root.get("lDongRegnCd"), filters.getLDongRegnCd()));
                if (StringUtils.hasText(filters.getLDongSigunguCd())) {
                    predicates.add(criteriaBuilder.equal(root.get("lDongSigunguCd"), filters.getLDongSigunguCd()));
                }
            }
            if (StringUtils.hasText(filters.getAreacode())) {
                predicates.add(criteriaBuilder.equal(root.get("areaCode"), filters.getAreacode()));
            }
            if (StringUtils.hasText(filters.getTitle())) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + filters.getTitle() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return searchRepository.findAll(spec).stream()
                .map(searchEntity -> {
                    // 공통 SearchDto 생성
                    SearchDto searchDto = SearchDto.fromEntity(searchEntity);

                    // ContentType에 따라 상세 정보 DTO 조회 및 UnifiedContentDto 생성
                    TourSpotInfoDto tourSpotInfo = null;
                    CulturalFacilityInfoDto culturalFacilityInfo = null;
                    FestivalInfoDto festivalInfo = null;
                    TourCourseInfoDto tourCourseInfo = null;

                    String contentTypeId = searchDto.getContenttypeid();
                    String contentId = searchDto.getContentid();

                    switch (contentTypeId) {
                        case "12": // 관광지
                            tourSpotInfo = tourSpotInfoService.getTourSpotById(contentId).orElse(null);
                            break;
                        case "14": // 문화시설
                            culturalFacilityInfo = culturalFacilityInfoService.getCulturalFacilityById(contentId).orElse(null);
                            break;
                        case "15": // 축제/공연/행사
                            festivalInfo = festivalInfoService.getFestivalById(contentId).orElse(null);
                            break;
                        case "25": // 여행 코스
                            tourCourseInfo = tourCourseInfoService.getTourCourseById(contentId).orElse(null);
                            break;
                        // 다른 contentTypeId에 대한 case는 여기에 추가
                        default:
                            // 해당 타입의 상세 정보가 없거나 정의되지 않은 경우
                            break;
                    }

                    return UnifiedContentDto.fromSearchAndDetails(
                            searchEntity, // Search 엔티티 자체를 넘겨서 UnifiedContentDto.fromSearchAndDetails에서 SearchDto로 변환하도록
                            tourSpotInfo,
                            culturalFacilityInfo,
                            festivalInfo,
                            tourCourseInfo
                    );
                })
                .collect(Collectors.toList());
    }

    public List<RandomSearchDto> getRandomSearchesByContentTypeId(String contentTypeId, int limit) {
        Specification<Search> spec = (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("contentTypeid"), contentTypeId);

        List<Search> allMatchingSearches = searchRepository.findAll(spec);

        // Shuffle the list to randomize the order
        Collections.shuffle(allMatchingSearches);

        // Limit the results to the requested number
        List<UnifiedContentDto> limitedUnifiedContents = allMatchingSearches.stream()
                .limit(limit)
                .map(searchEntity -> {
                    TourSpotInfoDto tourSpotInfo = null;
                    CulturalFacilityInfoDto culturalFacilityInfo = null;
                    FestivalInfoDto festivalInfo = null;
                    TourCourseInfoDto tourCourseInfo = null;

                    String currentContentTypeId = searchEntity.getContentTypeid();
                    String contentId = searchEntity.getContentid();

                    switch (currentContentTypeId) {
                        case "12": // 관광지
                            tourSpotInfo = tourSpotInfoService.getTourSpotById(contentId).orElse(null);
                            break;
                        case "14": // 문화시설
                            culturalFacilityInfo = culturalFacilityInfoService.getCulturalFacilityById(contentId).orElse(null);
                            break;
                        case "15": // 축제/공연/행사
                            festivalInfo = festivalInfoService.getFestivalById(contentId).orElse(null);
                            break;
                        case "25": // 여행 코스
                            tourCourseInfo = tourCourseInfoService.getTourCourseById(contentId).orElse(null);
                            break;
                        default:
                            break;
                    }

                    return UnifiedContentDto.fromSearchAndDetails(
                            searchEntity,
                            tourSpotInfo,
                            culturalFacilityInfo,
                            festivalInfo,
                            tourCourseInfo
                    );
                })
                .collect(Collectors.toList());

        // Map the UnifiedContentDto list to RandomSearchResponseDto list
        return limitedUnifiedContents.stream()
                .map(RandomSearchDto::fromUnifiedContentDto)
                .collect(Collectors.toList());
    }


    public List<String> getAvailableCat1Options() {
        return searchRepository.findDistinctCat1();
    }

    public List<String> getAvailableCat2Options(String cat1) {
        if (!StringUtils.hasText(cat1)) {
            return List.of();
        }
        return searchRepository.findDistinctCat2ByCat1(cat1);
    }

    public List<String> getAvailableCat3Options(String cat1, String cat2) {
        if (!StringUtils.hasText(cat1) || !StringUtils.hasText(cat2)) {
            return List.of();
        }
        return searchRepository.findDistinctCat3ByCat1AndCat2(cat1, cat2);
    }

    public List<String> getAvailableLDongRegnCdOptions() {
        return searchRepository.findDistinctLDongRegnCd();
    }

    public List<String> getAvailableLDongSigunguCdOptions(String lDongRegnCd) {
        if (!StringUtils.hasText(lDongRegnCd)) {
            return List.of();
        }
        return searchRepository.findDistinctLDongSigunguCdByLDongRegnCd(lDongRegnCd);
    }
}
