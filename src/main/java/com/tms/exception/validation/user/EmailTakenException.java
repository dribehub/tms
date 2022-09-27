package com.tms.exception.validation.user;

import javax.validation.ValidationException;

public class EmailTakenException extends ValidationException {

    public EmailTakenException() {
        super("This email is already in use");
    }

    public EmailTakenException(String email) {
        super(String.format("Email '%s' is already in use", email));
    }
}
