package com.company.lms.backend.controllers.timelogs.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateTimeLogRequest {

    @NotBlank(message = "Description must be informed")
    private String description;

    @NotNull(message = "Started At must be informed")
    private LocalDateTime startedAt;

    @NotNull(message = "Completed At must be informed")
    private LocalDateTime completedAt;

    @NotNull(message = "Enrollment ID must be informed")
    private Long enrollmentId;

    @NotNull(message = "Category ID must be informed")
    private Long categoryId;

}
