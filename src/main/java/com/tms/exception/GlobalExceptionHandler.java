package com.tms.exception;

import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorDetails> handle(Exception ex, WebRequest request, HttpStatus status) {
        Date date = new Date();
        String message = ex.getMessage();
        String description = request.getDescription(false);
        ErrorDetails errorDetails = new ErrorDetails(date, message, description);
        return new ResponseEntity<>(errorDetails, status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> handle(EntityNotFoundException ex, WebRequest request) {
        return handle(ex, request, HttpStatus.NOT_FOUND);
    }

/*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handle(Exception ex, WebRequest request) {
        return handle(ex, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }
*/

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ErrorDetails> handle(RuntimeException ex, WebRequest request) {
        return handle(ex, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidRequestStateException.class)
    public ResponseEntity<ErrorDetails> handle(InvalidRequestStateException ex, WebRequest request) {
        return handle(ex, request, HttpStatus.BAD_REQUEST);
    }
}