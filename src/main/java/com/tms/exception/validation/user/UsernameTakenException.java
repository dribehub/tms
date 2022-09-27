package com.tms.exception.validation.user;

import javax.validation.ValidationException;

public class UsernameTakenException extends ValidationException {

    public UsernameTakenException() {
        super("This username is taken");
    }

    public UsernameTakenException(String username) {
        super(String.format("Username '%s' is taken", username));
    }
}
