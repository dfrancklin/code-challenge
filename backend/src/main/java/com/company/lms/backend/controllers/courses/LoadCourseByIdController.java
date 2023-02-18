package com.company.lms.backend.controllers.courses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.controllers.courses.mappers.CourseResponseMapper;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.services.courses.LoadCourseByIdService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class LoadCourseByIdController {

    private final LoadCourseByIdService loadCourseByIdService;

    @GetMapping("/{id}")
    public CourseResponse load(@PathVariable Long id) {
        Course course = loadCourseByIdService.load(id);
        return CourseResponseMapper.map(course);
    }

}
