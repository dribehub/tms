package com.tms.exception.validation.user;

import javax.validation.ValidationException;

public class InvalidEmailFormatException extends ValidationException {

    public InvalidEmailFormatException() {
        super("This email is not a valid email format");
    }

    public InvalidEmailFormatException(String email) {
        super(String.format("'%s' is not a valid email format", email));
    }
}
