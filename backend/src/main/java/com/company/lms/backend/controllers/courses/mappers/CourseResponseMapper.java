package com.company.lms.backend.controllers.courses.mappers;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.controllers.courses.dtos.CreatorResponse;
import com.company.lms.backend.models.Course;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseResponseMapper {

    public static CourseResponse map(Course course) {
        CreatorResponse creator = CreatorResponse.builder()
                .id(course.getCreator().getId())
                .firstName(course.getCreator().getFirstName())
                .lastName(course.getCreator().getLastName())
                .build();

        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .enabled(course.isEnabled())
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .creator(creator)
                .build();
    }
}
