package com.company.lms.backend.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.company.lms.backend.enums.EnrollmentStatus;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Enrollment;

public interface EnrollmentsRepository extends PagingAndSortingRepository<Enrollment, Long> {

    Page<Enrollment> findAllByStudent(Account account, Pageable pageable);

    Optional<Enrollment> findByIdAndStudent(Long id, Account account);

    List<Enrollment> findAllByStartedAtBeforeAndStatus(LocalDateTime startedAt, EnrollmentStatus status);

    Integer countByStudentAndStatus(Account account, EnrollmentStatus status);

}
