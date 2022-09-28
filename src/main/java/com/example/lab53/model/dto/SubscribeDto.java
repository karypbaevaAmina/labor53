package com.example.lab53.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SubscribeDto {
    private Long id;
    private EventDto event;
    private String email;
    private LocalDateTime registerDateTime;

}
