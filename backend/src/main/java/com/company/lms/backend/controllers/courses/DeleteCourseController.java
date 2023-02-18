package com.company.lms.backend.controllers.courses;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.services.courses.DeleteCourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
public class DeleteCourseController {

    private final DeleteCourseService deleteCourseService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteCourseService.delete(id);
    }

}
