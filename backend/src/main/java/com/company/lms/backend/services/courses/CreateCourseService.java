package com.company.lms.backend.services.courses;

import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.courses.dtos.CreateCourseRequest;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.repositories.CoursesRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCourseService {

    private final CoursesRepository repository;

    public Course create(CreateCourseRequest request) {
        Account account = AuthenticationHelper.getAccount();
        Course course = Course.builder()
                .name(request.getName())
                .description(request.getDescription())
                .creator(account)
                .build();

        return repository.save(course);
    }
}
