package com.tms.exception;

import com.sun.jdi.request.InvalidRequestStateException;
import com.tms.dto.details.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.Date;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorDetails> handle(Exception ex, WebRequest request, HttpStatus status) {
        String description = request.getDescription(false);
        ErrorDetails details = new ErrorDetails(new Date(), ex.getMessage(), description);
        return new ResponseEntity<>(details, status);
    }

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ErrorDetails> handle(CustomRuntimeException ex, WebRequest request) {
        return handle(ex, request, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidRequestStateException.class)
    public ResponseEntity<ErrorDetails> handle(InvalidRequestStateException ex, WebRequest request) {
        return handle(ex, request, BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDetails> handle(ValidationException ex, WebRequest request) {
        return handle(ex, request, BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> handle(EntityNotFoundException ex, WebRequest request) {
        return handle(ex, request, NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDetails> handle(BadCredentialsException ex, WebRequest request) {
        return handle(ex, request, UNAUTHORIZED);
    }
}
