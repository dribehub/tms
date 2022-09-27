package com.tms.exception.validation;

import com.tms.exception.CustomRuntimeException;

public class EmailNotValidException extends CustomRuntimeException {

    public EmailNotValidException() {
        super("This email is not a valid email format");
    }

    public EmailNotValidException(String email) {
        super(String.format("'%s' is not a valid email format", email));
    }
}
