package com.tms.exception;

public class CustomRuntimeException extends RuntimeException {

    public CustomRuntimeException() {
    }

    public CustomRuntimeException(String message) {
        super(message);
    }
}
