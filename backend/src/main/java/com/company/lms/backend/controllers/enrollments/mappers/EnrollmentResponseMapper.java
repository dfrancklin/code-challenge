package com.company.lms.backend.controllers.enrollments.mappers;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.controllers.courses.mappers.CourseResponseMapper;
import com.company.lms.backend.controllers.enrollments.dtos.EnrollmentResponse;
import com.company.lms.backend.models.Enrollment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnrollmentResponseMapper {

    public static EnrollmentResponse map(Enrollment enrollment) {
        CourseResponse course = CourseResponseMapper.map(enrollment.getCourse());

        return EnrollmentResponse.builder()
                .id(enrollment.getId())
                .status(enrollment.getStatus())
                .startedAt(enrollment.getStartedAt())
                .completedAt(enrollment.getCompletedAt())
                .updatedAt(enrollment.getUpdatedAt())
                .course(course)
                .build();
    }
}
