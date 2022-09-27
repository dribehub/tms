package com.tms.exception.validation.trip;

import javax.validation.ValidationException;

public class InvalidItineraryException extends ValidationException {

    public InvalidItineraryException() {
        super("Field `from` and `to` cannot be equal");
    }
}
