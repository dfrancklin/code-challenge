package com.company.lms.backend.controllers.enrollments.dtos;

import java.time.LocalDateTime;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.enums.EnrollmentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {

    private Long id;

    private EnrollmentStatus status;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

    private LocalDateTime updatedAt;

    private CourseResponse course;

}
