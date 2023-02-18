package com.company.lms.backend.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Enrollment;
import com.company.lms.backend.models.TimeLog;

public interface TimeLogsRepository extends PagingAndSortingRepository<TimeLog, Long> {

    Page<TimeLog> findAllByStudentAndEnrollment(Account account, Enrollment enrollment, Pageable pageable);

    Optional<TimeLog> findByIdAndStudent(Long id, Account account);

}
