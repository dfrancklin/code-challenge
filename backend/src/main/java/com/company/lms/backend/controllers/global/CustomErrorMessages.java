package com.company.lms.backend.controllers.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomErrorMessages {

    MUST_BE_AT_LEAST_16YO("You must be at least 16 years old"),
    MAX_IN_PROGRESS_ENROLLMENTS("You reached the max number of Courses in progress"),
    ENROLLMENT_ALREADY_IN_FINAL_STATUS("The Enrollment is already in the final status and it cannot be changed"),
    BODY_MISSING("The request body is not present"),
    INVALID_CONTENT_TYPE("Invalid content-type"),
    POSSIBLY_DUPLICATED_RECORDS(
            "The record you are trying to create probably exists already. Check your data before trying again.");

    private String message;

}
