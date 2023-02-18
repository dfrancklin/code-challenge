package com.company.lms.backend.services.timelogs;

import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.timelogs.dtos.CreateTimeLogRequest;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Category;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.repositories.TimeLogsRepository;
import com.company.lms.backend.security.AuthenticationHelper;
import com.company.lms.backend.services.enrollments.LoadEnrollmentByIdService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateTimeLogService {

    private final TimeLogsRepository repository;

    private final LoadEnrollmentByIdService loadEnrollmentByIdService;

    public TimeLog create(CreateTimeLogRequest request) {
        Account account = AuthenticationHelper.getAccount();
        Category category = Category.builder().id(request.getCategoryId()).build();
        Enrollment enrollment = loadEnrollmentByIdService.load(request.getEnrollmentId());

        TimeLog timeLog = TimeLog.builder()
                .description(request.getDescription())
                .startedAt(request.getStartedAt())
                .completedAt(request.getCompletedAt())
                .student(account)
                .enrollment(enrollment)
                .category(category)
                .build();

        return repository.save(timeLog);
    }
}
