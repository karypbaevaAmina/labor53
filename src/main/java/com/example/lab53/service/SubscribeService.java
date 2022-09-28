package com.example.lab53.service;

import com.example.lab53.dao.EventDao;
import com.example.lab53.dao.SubscribeDao;
import com.example.lab53.model.dto.EventDto;
import com.example.lab53.model.dto.SubscribeDto;
import com.example.lab53.model.Event;
import com.example.lab53.model.Subscribe;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubscribeService {
    private final SubscribeDao subscribeDao;
    private final EventDao eventDao;

    public ResponseEntity<?> createASubscription(String email, Long eventId) {
        Long id = subscribeDao.create(email, eventId);
        Subscribe subscribe = subscribeDao.findById(id).orElseThrow();
        Event event = eventDao.findById(subscribe.getEvent().getId()).orElseThrow();

        if (event.getDateTime().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(SubscribeDto.builder()
                .id(subscribe.getId())
                .event(EventDto.builder()
                        .id(event.getId())
                        .name(event.getName())
                        .description(event.getDescription())
                        .dateTime(event.getDateTime())
                        .build())
                .email(subscribe.getEmail())
                .registerDateTime(subscribe.getRegisterDateTime())
                .build(),
                HttpStatus.OK);
    }

    public void deleteSubscription(String email, Long eventId){
        Subscribe subscribe = subscribeDao.findByEmailAndEventId(email, eventId).orElseThrow();
        subscribeDao.delete(subscribe.getId());
    }
}
