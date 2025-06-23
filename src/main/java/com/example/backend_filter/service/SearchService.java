package com.example.backend_filter.service;

import com.example.backend_filter.dto.SearchDto;
import com.example.backend_filter.dto.SearchFilterRequest;
import com.example.backend_filter.model.Search;
import com.example.backend_filter.repository.SearchRepository;
import com.example.backend_filter.common.exception.NotFound;

import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true) // 조회 성능 최적화
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public List<SearchDto> searchContents(SearchFilterRequest filterRequest) {
        List<Search> results = searchRepository.findAll((Specification<Search>) (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            Optional.ofNullable(filterRequest.getContentType()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("contentType"), val))
            );
            Optional.ofNullable(filterRequest.getCat1()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("cat1"), val))
            );
            Optional.ofNullable(filterRequest.getCat2()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("cat2"), val))
            );
            Optional.ofNullable(filterRequest.getCat3()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("cat3"), val))
            );
            Optional.ofNullable(filterRequest.getAreaCode()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("areaCode"), val))
            );
            Optional.ofNullable(filterRequest.getLDongRegnCd()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("lDongRegnCd"), val))
            );
            Optional.ofNullable(filterRequest.getLDongSigunguCd()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.equal(root.get("lDongSigunguCd"), val))
            );

            // 날짜 범위 필터링
            Optional.ofNullable(filterRequest.getEventStartDate()).ifPresent(date ->
                    predicates.add(cb.greaterThanOrEqualTo(root.get("eventStartDate"), date))
            );
            Optional.ofNullable(filterRequest.getEventEndDate()).ifPresent(date ->
                    predicates.add(cb.lessThanOrEqualTo(root.get("eventEndDate"), date))
            );

            // 키워드 검색
            Optional.ofNullable(filterRequest.getKeyword()).filter(s -> !s.isEmpty()).ifPresent(val ->
                    predicates.add(cb.like(root.get("title"), "%" + val + "%"))
            );

            return cb.and(predicates.toArray(new Predicate[0]));
        });

        return results.stream()
                .map(SearchDto::new)
                .collect(Collectors.toList());
    }

    public SearchDto getContentById(String contentId) {
        return searchRepository.findById(contentId)
                .map(SearchDto::new)
                .orElseThrow(() -> new NotFound("ContentNotFound"+ contentId));
    }

    @Transactional // 쓰기 작업이므로 별도로 @Transactional 적용
    public SearchDto createContent(SearchDto searchDto) {
        Search search = searchDto.toEntity();
        Search savedSearch = searchRepository.save(search);
        return new SearchDto(savedSearch);
    }
    public List<String> getDistinctCat1() {
        return searchRepository.findDistinctCat1();
    }
    public List<String> getDistinctCat2ByCat1(String cat1) {
        return searchRepository.findDistinctCat2ByCat1(cat1);
    }
    public List<String> getDistinctCat3ByCat1AndCat2(String cat1, String cat2) {
        return searchRepository.findDistinctCat3ByCat1AndCat2(cat1, cat2);
    }
    public List<String> getDistinctLDongRegnCd() {
        return searchRepository.findDistinctLDongRegnCd();
    }
    public List<String> getDistinctLDongSigunguCdByLDongRegnCd(String lDongRegnCd) {
        return searchRepository.findDistinctLDongSigunguCdByLDongRegnCd(lDongRegnCd);
    }
}