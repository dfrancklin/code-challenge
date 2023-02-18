package com.company.lms.backend.controllers.courses;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.courses.dtos.CourseResponse;
import com.company.lms.backend.controllers.courses.mappers.CourseResponseMapper;
import com.company.lms.backend.services.courses.LoadAllCoursesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class LoadAllCoursesController {

    private final LoadAllCoursesService loadAllCoursesService;

    @GetMapping
    public Page<CourseResponse> load(@RequestParam(required = false) Integer page) {
        page = page == null ? 0 : page;

        return loadAllCoursesService.load(page).map(CourseResponseMapper::map);
    }

}
