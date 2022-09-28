package com.example.lab53.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDto {
    private Long id;
    private LocalDateTime dateTime;
    private String name;
    private String description;
}
