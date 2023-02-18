package com.company.lms.backend.services.enrollments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.repositories.EnrollmentsRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadAllEnrollmentsService {

    private final EnrollmentsRepository repository;

    public Page<Enrollment> load(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Direction.DESC, "startedAt"));
        Account account = AuthenticationHelper.getAccount();

        return repository.findAllByStudent(account, pageable);
    }

}
