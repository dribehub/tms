package com.tms.exception.validation;

import com.tms.exception.CustomRuntimeException;

public class UsernameTakenException extends CustomRuntimeException {

    public UsernameTakenException() {
        super("This username is taken.");
    }

    public UsernameTakenException(String username) {
        super(String.format("Username '%s' is taken.", username));
    }
}
