package com.company.lms.backend.services.timelogs;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.TimeLog;
import com.company.lms.backend.repositories.TimeLogsRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadTimeLogByIdService {

    private final TimeLogsRepository repository;

    public TimeLog load(Long id) throws EntityNotFoundException {
        Account account = AuthenticationHelper.getAccount();
        return repository.findByIdAndStudent(id, account)
                .orElseThrow(() -> new EntityNotFoundException(String.format("TimeLog with ID '%d' not found", id)));
    }

}
