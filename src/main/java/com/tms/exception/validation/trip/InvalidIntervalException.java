
package com.tms.exception.validation.trip;

import javax.validation.ValidationException;

public class InvalidIntervalException extends ValidationException {

    public InvalidIntervalException() {
        super("Arrival cannot be earlier than departure");
    }
}
