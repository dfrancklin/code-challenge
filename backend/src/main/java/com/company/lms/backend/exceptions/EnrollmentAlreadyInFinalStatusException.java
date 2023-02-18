package com.company.lms.backend.exceptions;

public class EnrollmentAlreadyInFinalStatusException extends Exception {

    public EnrollmentAlreadyInFinalStatusException() {
        super();
    }

    public EnrollmentAlreadyInFinalStatusException(String message) {
        super(message);
    }

}
