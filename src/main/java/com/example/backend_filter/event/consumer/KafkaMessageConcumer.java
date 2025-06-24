package com.example.backend_filter.event.consumer;

import com.example.backend_filter.dto.SearchDto;
import com.example.backend_filter.entity.Search;
import com.example.backend_filter.event.consumer.message.search.SearchEvent;
import com.example.backend_filter.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageConcumer {
    private final SearchRepository searchRepository;

    @KafkaListener(
            topics = SearchEvent.Topic,
            properties = {
                    JsonDeserializer.VALUE_DEFAULT_TYPE
                            + ":com.example.backend_filter.event.consumer.message.search.SearchEvent"
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
}
