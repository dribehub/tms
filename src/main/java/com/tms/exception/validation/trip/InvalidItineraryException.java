package com.tms.exception.validation.trip;

import javax.validation.ValidationException;

public class InvalidItineraryException extends ValidationException {

    public InvalidItineraryException() {
        super("There is no itinerary from a country to itself");
    }
}
