package com.emmanuelepp.todoapi.persistence.entity;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tittle;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean completed;
    private TaskStatus taskStatus;
}
