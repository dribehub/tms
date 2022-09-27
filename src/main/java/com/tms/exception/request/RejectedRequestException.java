package com.tms.exception.request;

import com.sun.jdi.request.InvalidRequestStateException;

public class RejectedRequestException extends InvalidRequestStateException {

    public RejectedRequestException() {
        super("This request was rejected");
    }

    public RejectedRequestException(String reason) {
        super(String.format("This request was rejected. Reason: %s", reason));
    }
}
