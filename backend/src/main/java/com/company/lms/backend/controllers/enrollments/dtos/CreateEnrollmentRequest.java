package com.company.lms.backend.controllers.enrollments.dtos;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateEnrollmentRequest {

    @NotNull(message = "courseId must be informed")
    private Long courseId;

}
