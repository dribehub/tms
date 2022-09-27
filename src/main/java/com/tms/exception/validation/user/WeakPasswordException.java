package com.tms.exception.validation.user;

import javax.validation.ValidationException;

public class WeakPasswordException extends ValidationException {

    private final static String
            WEAK_PASSWORD = "This password is not strong enough",
            TOO_SHORT = "Password must be at least 8 characters long",
            NO_UPPERCASE = "Password must contain at least 1 uppercase character",
            NO_DIGIT = "Password must contain at least 1 digit",
            NO_SYMBOL = "Password must contain at least 1 symbol";

    public WeakPasswordException() {
        super(WEAK_PASSWORD);
    }

    public WeakPasswordException(String message) {
        super(message);
    }

    public static WeakPasswordException tooShort() {
        return new WeakPasswordException(TOO_SHORT);
    }

    public static WeakPasswordException noUppercase() {
        return new WeakPasswordException(NO_UPPERCASE);
    }

    public static WeakPasswordException noDigit() {
        return new WeakPasswordException(NO_DIGIT);
    }

    public static WeakPasswordException noSymbol() {
        return new WeakPasswordException(NO_SYMBOL);
    }
}
