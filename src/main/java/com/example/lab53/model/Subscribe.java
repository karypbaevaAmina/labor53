package com.example.lab53.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Subscribe {
    private Long id;
    private Event event;
    private String email;
    private LocalDateTime registerDateTime;
}
