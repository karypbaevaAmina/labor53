package com.example.lab53.controller;


import com.example.lab53.model.dto.EventDto;
import com.example.lab53.service.EventService;
import com.example.lab53.service.SubscribeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")

public class EventController {

    private final SubscribeService subscribeService;
    private final EventService eventService;

    public EventController(SubscribeService subscribeService, EventService eventService) {
        this.subscribeService = subscribeService;
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventDto> getAll() {
        return eventService.getAll();
    }

    @GetMapping("/{email}")
    public List<EventDto> getAllSubscribe(@PathVariable String email){
        return eventService.getAllBySubscribe(email);
    }


}

