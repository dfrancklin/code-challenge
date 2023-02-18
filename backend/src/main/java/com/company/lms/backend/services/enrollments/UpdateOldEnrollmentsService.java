package com.company.lms.backend.services.enrollments;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.lms.backend.enums.EnrollmentStatus;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.repositories.EnrollmentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOldEnrollmentsService {

    private final EnrollmentsRepository repository;

    public void update() {
        LocalDateTime dateLimit = LocalDateTime.now().minusMonths(6);
        List<Enrollment> oldEnrollments = repository.findAllByStartedAtBeforeAndStatus(dateLimit,
                EnrollmentStatus.IN_PROGRESS);

        oldEnrollments.forEach(enrollment -> {
            enrollment.setStatus(EnrollmentStatus.INCOMPLETE);
            enrollment.setCompletedAt(LocalDateTime.now());
            repository.save(enrollment);
        });
    }
}
