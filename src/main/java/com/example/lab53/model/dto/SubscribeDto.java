package com.example.lab53.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SubscribeDto {
    private Long id;
    private EventDto event;
    private String email;
    private LocalDateTime registerDateTime;

}
