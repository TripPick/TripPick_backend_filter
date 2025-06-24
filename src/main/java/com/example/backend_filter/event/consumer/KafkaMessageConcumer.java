package com.example.backend_filter.event.consumer;

import com.example.backend_filter.dto.SearchDto;
import com.example.backend_filter.entity.Search;
import com.example.backend_filter.event.consumer.message.common.CommonInfoEvent;
import com.example.backend_filter.event.consumer.message.course.CourseInfoEvent;
import com.example.backend_filter.event.consumer.message.cultural.CulturalInfoEvent;
import com.example.backend_filter.event.consumer.message.event.EventInfoEvent;
import com.example.backend_filter.event.consumer.message.search.SearchEvent;
import com.example.backend_filter.event.consumer.message.spot.SpotInfoEvent;
import com.example.backend_filter.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageConcumer {
    private final SearchRepository searchRepository;
    private final DetailCommonRepository detailCommonRepository;
    private final TourSpotInfoRepository tourSpotInfoRepository;
    private final CulturalFacilityInfoRepository culturalFacilityInfoRepository;
    private final FestivalInfoRepository festivalInfoRepository;
    private final TourCourseInfoRepository tourCourseInfoRepository;

    private static final String VALUE_DEFAULT_TYPE = JsonDeserializer.VALUE_DEFAULT_TYPE;


    @Transactional
    @KafkaListener(
            topics = SearchEvent.Topic,
            properties = { VALUE_DEFAULT_TYPE + ":com.example.backend_filter.event.consumer.message.search.SearchEvent"
            }
    )
    void handleTourinfoEvent(SearchEvent event, Acknowledgment ack) {
        Optional<Search> content = searchRepository.findById(event.getSearch().getContentid());

        if (content.isEmpty()) {
            log.info("No existing Search content found for contentId: {}. Saving new entry.", event.getSearch().getContentid());
            searchRepository.save(event.getSearch());
        } else {
            log.debug("Search content already exists for contentId: {}. Skipping save.", event.getSearch().getContentid());

        }
    }

    @Transactional
    @KafkaListener(
            topics = CommonInfoEvent.Topic,
            properties = { VALUE_DEFAULT_TYPE + ":com.example.backend_filter.event.consumer.message.common.CommonInfoEvent" }
    )
    public void handleCommonInfoEvent(CommonInfoEvent event, Acknowledgment ack) {
        log.info("Received CommonInfoEvent for contentId: {}", event.getDetailCommon().getContentId());
        detailCommonRepository.save(event.getDetailCommon());
        // ack.acknowledge(); // 메시지 처리 완료 확인
    }

    /**
     * 관광지소개정보 저장
     */
    @Transactional
    @KafkaListener(
            topics = SpotInfoEvent.Topic,
            properties = { VALUE_DEFAULT_TYPE + ":com.example.backend_filter.event.consumer.message.spot.SpotInfoEvent" }
    )
    public void handleSpotInfoEvent(SpotInfoEvent event, Acknowledgment ack) {
        log.info("Received SpotInfoEvent for contentId: {}", event.getTourSpotInfo().getContentId());
        tourSpotInfoRepository.save(event.getTourSpotInfo());
    //  ack.acknowledge();
    }

    /**
     * 문화시설소개정보 저장
     */
    @Transactional
    @KafkaListener(
            topics = CulturalInfoEvent.Topic,
            properties = { VALUE_DEFAULT_TYPE + ":com.example.backend_filter.event.consumer.message.cultural.CulturalInfoEvent" }
    )
    public void handleCulturalInfoEvent(CulturalInfoEvent event, Acknowledgment ack) {
        log.info("Received CulturalInfoEvent for contentId: {}", event.getCulturalFacilityInfo().getContentId());
        culturalFacilityInfoRepository.save(event.getCulturalFacilityInfo());
    //  ack.acknowledge();
    }

    /**
     * 행사/공연/축제소개정보 저장
     */
    @Transactional
    @KafkaListener(
            topics = EventInfoEvent.Topic,
            properties = { VALUE_DEFAULT_TYPE + ":com.example.backend_filter.event.consumer.message.event.EventInfoEvent" }
    )
    public void handleEventInfoEvent(EventInfoEvent event, Acknowledgment ack) {
        log.info("Received EventInfoEvent for contentId: {}", event.getFestivalInfo().getContentId());
        festivalInfoRepository.save(event.getFestivalInfo());
//        ack.acknowledge();
    }

    /**
     * 여행코스소개정보 저장
     */
    @Transactional
    @KafkaListener(
            topics = CourseInfoEvent.Topic,
            properties = { VALUE_DEFAULT_TYPE + ":com.example.backend_filter.event.consumer.message.course.CourseInfoEvent" }
    )
    public void handleCourseInfoEvent(CourseInfoEvent event, Acknowledgment ack) {
        log.info("Received CourseInfoEvent for contentId: {}", event.getTourCourseInfo().getContentId());
        tourCourseInfoRepository.save(event.getTourCourseInfo());
//        ack.acknowledge();
    }
}
