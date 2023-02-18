package com.company.lms.backend.controllers.enrollments.dtos;

import javax.validation.constraints.NotNull;

import com.company.lms.backend.enums.EnrollmentStatus;

import lombok.Data;

@Data
public class UpdateEnrollmentRequest {

    @NotNull(message = "Status must be informed")
    private EnrollmentStatus status;

}
