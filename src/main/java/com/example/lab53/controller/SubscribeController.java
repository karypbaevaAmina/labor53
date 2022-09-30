package com.example.lab53.controller;

import com.example.lab53.model.Subscribe;
import com.example.lab53.model.dto.EventDto;
import com.example.lab53.model.dto.SubscribeDto;
import com.example.lab53.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    //удаление подписки через идентификатор и почту
    //http://localhost:8898/sub?email=qwe@qwe.qwe&eventId=2
    @DeleteMapping ("/sub")
    public String deleteSubscribe(@RequestParam String email, @RequestParam Long eventId) {   //удаление подписки через идентификатор и почту
        try {
            return subscribeService.deleteSubscription(email, eventId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        //подписка на событие добавляет в таблицу
    //http://localhost:8898/create?eventId=3&email=uuuu@uuu
    @PostMapping("/create")
    public ResponseEntity<?> createSubscribe (@RequestParam Long eventId, @RequestParam String email){
        return subscribeService.createASubscription(eventId, email);
    }

}