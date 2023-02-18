package com.company.lms.backend.services.enrollments;

import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.enrollments.dtos.UpdateEnrollmentRequest;
import com.company.lms.backend.enums.EnrollmentStatus;
import com.company.lms.backend.exceptions.EnrollmentAlreadyInFinalStatusException;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.repositories.EnrollmentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateEnrollmentService {

    private final EnrollmentsRepository repository;

    private final LoadEnrollmentByIdService loadEnrollmentByIdService;

    public Enrollment update(Long id, UpdateEnrollmentRequest request) throws EnrollmentAlreadyInFinalStatusException {
        Enrollment enrollment = loadEnrollmentByIdService.load(id);

        if (!EnrollmentStatus.IN_PROGRESS.equals(enrollment.getStatus())) {
            throw new EnrollmentAlreadyInFinalStatusException();
        }

        enrollment.setStatus(request.getStatus());

        return repository.save(enrollment);

    }

}
