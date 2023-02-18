package com.company.lms.backend.services.courses;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.company.lms.backend.enums.Role;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.repositories.CoursesRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadAllCoursesService {

    private final CoursesRepository repository;

    public Page<Course> load(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Direction.ASC, "name"));
        Account account = AuthenticationHelper.getAccount();

        if (Role.ROLE_ADMIN.equals(account.getRole())) {
            return repository.findAll(pageable);
        }

        return repository.findAllByEnabledIsTrue(pageable);
    }

}
