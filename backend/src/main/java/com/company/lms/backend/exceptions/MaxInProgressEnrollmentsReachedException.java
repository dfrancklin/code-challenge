package com.company.lms.backend.exceptions;

public class MaxInProgressEnrollmentsReachedException extends Exception {

    public MaxInProgressEnrollmentsReachedException() {
        super();
    }

    public MaxInProgressEnrollmentsReachedException(String message) {
        super(message);
    }

}
