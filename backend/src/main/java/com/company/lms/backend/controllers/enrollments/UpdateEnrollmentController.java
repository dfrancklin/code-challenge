package com.company.lms.backend.controllers.enrollments;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.enrollments.dtos.EnrollmentResponse;
import com.company.lms.backend.controllers.enrollments.dtos.UpdateEnrollmentRequest;
import com.company.lms.backend.controllers.enrollments.mappers.EnrollmentResponseMapper;
import com.company.lms.backend.exceptions.EnrollmentAlreadyInFinalStatusException;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.services.enrollments.UpdateEnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class UpdateEnrollmentController {

    private final UpdateEnrollmentService updateEnrollmentService;

    @PutMapping("/{id}")
    public EnrollmentResponse update(@PathVariable Long id, @Valid @RequestBody UpdateEnrollmentRequest request)
            throws EnrollmentAlreadyInFinalStatusException {
        Enrollment enrollment = updateEnrollmentService.update(id, request);
        return EnrollmentResponseMapper.map(enrollment);
    }

}
