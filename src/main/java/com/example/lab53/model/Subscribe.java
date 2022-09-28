package com.example.lab53.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Subscribe {
    private Long id;
    private Event event;
    private String email;
    private LocalDateTime registerDateTime;
}
