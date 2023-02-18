package com.company.lms.backend.controllers.enrollments;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.enrollments.dtos.EnrollmentResponse;
import com.company.lms.backend.controllers.enrollments.mappers.EnrollmentResponseMapper;
import com.company.lms.backend.services.enrollments.LoadAllEnrollmentsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class LoadAllEnrollmentsController {

    private final LoadAllEnrollmentsService loadAllEnrollmentsService;

    @GetMapping
    public Page<EnrollmentResponse> load(@RequestParam(required = false) Integer page) {
        page = page == null ? 0 : page;

        return loadAllEnrollmentsService.load(page).map(EnrollmentResponseMapper::map);
    }

}
