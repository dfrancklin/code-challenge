package com.company.lms.backend.controllers.global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.company.lms.backend.controllers.global.dtos.ErrorResponse;
import com.company.lms.backend.exceptions.AgeNotAllowedException;
import com.company.lms.backend.exceptions.EnrollmentAlreadyInFinalStatusException;
import com.company.lms.backend.exceptions.MaxInProgressEnrollmentsReachedException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> badCredentialsException(BadCredentialsException exception,
            WebRequest request) {
        return of(HttpStatus.UNAUTHORIZED, exception, request, exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFoundException(EntityNotFoundException exception,
            WebRequest request) {
        return of(HttpStatus.NOT_FOUND, exception, request, exception.getMessage());
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> disabledException(DisabledException exception, WebRequest request) {
        return of(HttpStatus.UNAUTHORIZED, exception, request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> accessDeniedException(AccessDeniedException exception, WebRequest request) {
        return of(HttpStatus.FORBIDDEN, exception, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> dataIntegrityViolationException(DataIntegrityViolationException exception,
            WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request,
                CustomErrorMessages.POSSIBLY_DUPLICATED_RECORDS.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validationException(ValidationException exception, WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request);
    }

    @ExceptionHandler(AgeNotAllowedException.class)
    public ResponseEntity<ErrorResponse> ageNotAllowedException(AgeNotAllowedException exception, WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request, CustomErrorMessages.MUST_BE_AT_LEAST_16YO.getMessage());
    }

    @ExceptionHandler(MaxInProgressEnrollmentsReachedException.class)
    public ResponseEntity<ErrorResponse> maxInProgressEnrollmentsReachedException(
            MaxInProgressEnrollmentsReachedException exception, WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request,
                CustomErrorMessages.MAX_IN_PROGRESS_ENROLLMENTS.getMessage());
    }

    @ExceptionHandler(EnrollmentAlreadyInFinalStatusException.class)
    public ResponseEntity<ErrorResponse> enrollmentAlreadyInFinalStatusException(
            EnrollmentAlreadyInFinalStatusException exception, WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request,
                CustomErrorMessages.ENROLLMENT_ALREADY_IN_FINAL_STATUS.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> httpMessageNotReadableException(HttpMessageNotReadableException exception,
            WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request, CustomErrorMessages.BODY_MISSING.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> httpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException exception, WebRequest request) {
        return of(HttpStatus.BAD_REQUEST, exception, request, CustomErrorMessages.INVALID_CONTENT_TYPE.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> missingServletRequestParameterException(
            MissingServletRequestParameterException exception, WebRequest request) {
        Map<String, Object> detail = new HashMap<>();
        detail.put("parameterName", exception.getParameterName());
        detail.put("parameterType", exception.getParameterType());

        return of(HttpStatus.BAD_REQUEST, exception, request, Arrays.asList(detail));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception,
            WebRequest request) {
        Map<String, Object> detail = new HashMap<>();

        detail.put("paramName", exception.getName());
        detail.put("paramValue", Optional.ofNullable(exception.getValue()).map(Object::toString).orElse(""));
        detail.put("errorMessage", exception.getMessage());

        return of(HttpStatus.BAD_REQUEST, exception, request, Arrays.asList(detail));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception,
            WebRequest request) {
        List<Object> details = exception.getBindingResult().getAllErrors().stream().map(e -> {
            Map<String, Object> error = new HashMap<>();

            error.put("objectName", e.getObjectName());
            error.put("errorMessage", e.getDefaultMessage());

            if (e instanceof FieldError) {
                FieldError fieldError = (FieldError) e;
                error.put("field", fieldError.getField());
                error.put("rejectedValue", fieldError.getRejectedValue());
            }

            return error;
        }).collect(Collectors.toList());

        return of(HttpStatus.BAD_REQUEST, exception, request, details);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception exception, WebRequest request) {
        return of(HttpStatus.INTERNAL_SERVER_ERROR, exception, request);
    }

    private ResponseEntity<ErrorResponse> of(HttpStatus status, Exception exception, WebRequest request) {
        return of(status, exception, request, null, null);
    }

    private ResponseEntity<ErrorResponse> of(HttpStatus status, Exception exception, WebRequest request,
            String message) {
        return of(status, exception, request, message, null);
    }

    private ResponseEntity<ErrorResponse> of(HttpStatus status, Exception exception, WebRequest request,
            List<Object> details) {
        return of(status, exception, request, null, details);
    }

    private ResponseEntity<ErrorResponse> of(HttpStatus status, Exception e, WebRequest request, String message,
            List<Object> details) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();

        log.error("An error occurred while trying to process the request to {}. Error: {}", path, e.getMessage());
        log.debug("Error stack:", e);

        int statusCode = status.value();
        String reasonPhrase = status.getReasonPhrase();
        ErrorResponse error = ErrorResponse.builder().status(statusCode).error(reasonPhrase).message(message).path(path)
                .details(details).build();

        return ResponseEntity.status(status).body(error);
    }

}
