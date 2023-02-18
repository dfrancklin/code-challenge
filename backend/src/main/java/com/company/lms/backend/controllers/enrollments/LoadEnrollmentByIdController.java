package com.company.lms.backend.controllers.enrollments;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.enrollments.dtos.EnrollmentResponse;
import com.company.lms.backend.controllers.enrollments.mappers.EnrollmentResponseMapper;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.services.enrollments.LoadEnrollmentByIdService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class LoadEnrollmentByIdController {

    private final LoadEnrollmentByIdService loadEnrollmentByIdService;

    @GetMapping("/{id}")
    public EnrollmentResponse load(@PathVariable Long id) {
        Enrollment enrollment = loadEnrollmentByIdService.load(id);
        return EnrollmentResponseMapper.map(enrollment);
    }

}
