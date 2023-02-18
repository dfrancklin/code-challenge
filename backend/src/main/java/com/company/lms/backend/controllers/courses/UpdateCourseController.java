package com.company.lms.backend.controllers.courses;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.controllers.courses.dtos.UpdateCourseRequest;
import com.company.lms.backend.controllers.courses.mappers.CourseResponseMapper;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.services.courses.UpdateCourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class UpdateCourseController {

    private final UpdateCourseService updateCourseService;

    @PutMapping("/{id}")
    public CourseResponse update(@PathVariable Long id, @Valid @RequestBody UpdateCourseRequest request) {
        Course course = updateCourseService.update(id, request);
        return CourseResponseMapper.map(course);
    }

}
