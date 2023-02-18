package com.company.lms.backend.services.courses;

import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.courses.dtos.UpdateCourseRequest;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.repositories.CoursesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateCourseService {

    private final CoursesRepository repository;

    private final LoadCourseByIdService loadCourseByIdService;

    public Course update(Long id, UpdateCourseRequest request) {
        Course course = loadCourseByIdService.load(id);

        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setEnabled(request.getEnabled());

        return repository.save(course);
    }

}
