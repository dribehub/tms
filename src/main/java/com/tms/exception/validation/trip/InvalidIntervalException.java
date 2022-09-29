
package com.tms.exception.validation.trip;

import javax.validation.ValidationException;

public class InvalidIntervalException extends ValidationException {

    public InvalidIntervalException() {
        super("Departure must be earlier than arrival");
    }
}
