package com.company.lms.backend.services.enrollments;

import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.enrollments.dtos.CreateEnrollmentRequest;
import com.company.lms.backend.enums.EnrollmentStatus;
import com.company.lms.backend.exceptions.MaxInProgressEnrollmentsReachedException;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.repositories.EnrollmentsRepository;
import com.company.lms.backend.security.AuthenticationHelper;
import com.company.lms.backend.services.courses.LoadCourseByIdService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateEnrollmentService {

    private final EnrollmentsRepository repository;

    private final LoadCourseByIdService loadCourseByIdService;

    public Enrollment create(CreateEnrollmentRequest request) throws MaxInProgressEnrollmentsReachedException {
        Account account = AuthenticationHelper.getAccount();
        Integer currentInProgressEnrollments = repository.countByStudentAndStatus(account,
                EnrollmentStatus.IN_PROGRESS);

        if (currentInProgressEnrollments >= 3) {
            throw new MaxInProgressEnrollmentsReachedException();
        }

        Course course = loadCourseByIdService.load(request.getCourseId());

        Enrollment enrollment = Enrollment.builder()
                .course(course)
                .student(account)
                .build();

        return repository.save(enrollment);
    }

}
