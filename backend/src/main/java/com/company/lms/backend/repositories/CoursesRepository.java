package com.company.lms.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.company.lms.backend.models.Course;

public interface CoursesRepository extends PagingAndSortingRepository<Course, Long> {

    Page<Course> findAllByEnabledIsTrue(Pageable pageable);

}
