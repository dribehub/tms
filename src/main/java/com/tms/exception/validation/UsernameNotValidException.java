package com.tms.exception.validation;

import com.tms.exception.CustomRuntimeException;

public class UsernameNotValidException extends CustomRuntimeException {

    public UsernameNotValidException() {
        super("This username is not a valid.");
    }

    public UsernameNotValidException(String email) {
        super(String.format("'%s' is not a valid username.", email));
    }
}
