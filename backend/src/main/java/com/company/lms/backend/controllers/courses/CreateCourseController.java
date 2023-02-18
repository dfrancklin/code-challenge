package com.company.lms.backend.controllers.courses;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.controllers.courses.dtos.CreateCourseRequest;
import com.company.lms.backend.controllers.courses.mappers.CourseResponseMapper;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.services.courses.CreateCourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class CreateCourseController {

    private final CreateCourseService createCourseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse create(@Valid @RequestBody CreateCourseRequest request) {
        Course course = createCourseService.create(request);
        return CourseResponseMapper.map(course);
    }

}
