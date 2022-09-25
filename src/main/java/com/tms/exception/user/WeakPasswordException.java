package com.tms.exception.user;

import com.tms.exception.CustomRuntimeException;

public class WeakPasswordException extends CustomRuntimeException {

    public WeakPasswordException() {
        super("This password is not strong enough.");
    }

    public WeakPasswordException(String message) {
        super(message);
    }

    public static WeakPasswordException tooShort() {
        String message = "Password must be at least 8 characters long.";
        return new WeakPasswordException(message);
    }

    public static WeakPasswordException noUppercase() {
        String message = "Password must contain at least 1 uppercase character.";
        return new WeakPasswordException(message);
    }

    public static WeakPasswordException noDigit() {
        String message = "Password must contain at least 1 digit.";
        return new WeakPasswordException(message);
    }

    public static WeakPasswordException noSymbol() {
        String message = "Password must contain at least 1 symbol.";
        return new WeakPasswordException(message);
    }
}
