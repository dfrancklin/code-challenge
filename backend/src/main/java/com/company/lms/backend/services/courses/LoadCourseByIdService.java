package com.company.lms.backend.services.courses;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.company.lms.backend.enums.Role;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.models.Course;
import com.company.lms.backend.repositories.CoursesRepository;
import com.company.lms.backend.security.AuthenticationHelper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoadCourseByIdService {

    private final CoursesRepository repository;

    public Course load(Long id) throws EntityNotFoundException {
        Account account = AuthenticationHelper.getAccount();
        Course course = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Course with ID '%d' not found", id)));

        if (Role.ROLE_ADMIN.equals(account.getRole())) {
            return course;
        }

        if (!course.isEnabled()) {
            throw new EntityNotFoundException(String.format("Course with ID '%d' not found", id));
        }

        return course;
    }

}
