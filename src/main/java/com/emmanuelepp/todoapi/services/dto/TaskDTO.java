package com.emmanuelepp.todoapi.services.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private String tittle;
    private String description;
    private LocalDateTime eta;
}
