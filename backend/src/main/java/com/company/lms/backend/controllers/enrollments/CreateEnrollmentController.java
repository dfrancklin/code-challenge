package com.company.lms.backend.controllers.enrollments;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.enrollments.dtos.CreateEnrollmentRequest;
import com.company.lms.backend.controllers.enrollments.dtos.EnrollmentResponse;
import com.company.lms.backend.controllers.enrollments.mappers.EnrollmentResponseMapper;
import com.company.lms.backend.exceptions.MaxInProgressEnrollmentsReachedException;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.services.enrollments.CreateEnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class CreateEnrollmentController {

    private final CreateEnrollmentService createEnrollmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResponse create(@Valid @RequestBody CreateEnrollmentRequest request)
            throws MaxInProgressEnrollmentsReachedException {
        Enrollment enrollment = createEnrollmentService.create(request);
        return EnrollmentResponseMapper.map(enrollment);
    }

}
