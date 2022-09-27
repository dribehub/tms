package com.tms.exception.validation.user;

import javax.validation.ValidationException;

public class InvalidUsernameException extends ValidationException {

    public InvalidUsernameException() {
        super("This username is not a valid");
    }

    public InvalidUsernameException(String email) {
        super(String.format("'%s' is not a valid username", email));
    }
}
