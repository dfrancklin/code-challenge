package com.company.lms.backend.services.timelogs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.repositories.TimeLogsRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadAllTimeLogsService {

    private final TimeLogsRepository repository;

    public Page<TimeLog> load(Long enrollmentId, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Direction.DESC, "startedAt"));
        Account account = AuthenticationHelper.getAccount();
        Enrollment enrollment = Enrollment.builder().id(enrollmentId).build();

        return repository.findAllByStudentAndEnrollment(account, enrollment, pageable);
    }

}
