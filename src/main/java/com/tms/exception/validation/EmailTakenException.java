package com.tms.exception.validation;

import com.tms.exception.CustomRuntimeException;

public class EmailTakenException extends CustomRuntimeException {

    public EmailTakenException() {
        super("This email is already in use.");
    }

    public EmailTakenException(String email) {
        super(String.format("Email '%s' is already in use.", email));
    }
}
