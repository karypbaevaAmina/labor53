package com.example.lab53.service;

import com.example.lab53.dao.EventDao;
import com.example.lab53.model.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventDao eventDao;

    public List<EventDto> getAll() {
        return eventDao.getAllEvents().stream()
                .map(event -> EventDto.builder()
                        .id(event.getId())
                        .name(event.getName())
                        .description(event.getDescription())
                        .dateTime(event.getDateTime())
                        .build())
                .collect(Collectors.toList());
    }

    public List<EventDto> getAllBySubscribe(String email){
        return eventDao.findBySubscribeEmail(email).stream()
                .map(event -> EventDto.builder()
                        .id(event.getId())
                        .dateTime(event.getDateTime())
                        .name(event.getName())
                        .description(event.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
