package com.company.lms.backend.services.courses;

import org.springframework.stereotype.Service;

import com.company.lms.backend.models.Course;
import com.company.lms.backend.repositories.CoursesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteCourseService {

    private final CoursesRepository repository;

    private final LoadCourseByIdService loadCourseByIdService;

    public void delete(Long id) {
        Course course = loadCourseByIdService.load(id);

        repository.delete(course);
    }

}
