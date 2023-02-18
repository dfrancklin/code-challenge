package com.company.lms.backend.controllers.timelogs.dtos;

import java.time.LocalDateTime;

import com.company.lms.backend.models.Category;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TimeLogResponse {

    private Long id;

    private String description;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Category category;

}
