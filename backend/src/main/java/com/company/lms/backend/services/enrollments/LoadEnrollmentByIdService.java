package com.company.lms.backend.services.enrollments;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.repositories.EnrollmentsRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadEnrollmentByIdService {

    private final EnrollmentsRepository repository;

    public Enrollment load(Long id) throws EntityNotFoundException {
        Account account = AuthenticationHelper.getAccount();

        return repository.findByIdAndStudent(id, account)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Enrollment with ID '%d' not found", id)));
    }

}
