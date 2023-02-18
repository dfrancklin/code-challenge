package com.company.lms.backend.controllers.courses.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourseResponse {

    private Long id;

    private String name;

    private String description;

    private boolean enabled;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private CreatorResponse creator;

}
