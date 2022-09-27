package com.tms.exception.request;

import com.sun.jdi.request.InvalidRequestStateException;

public class NullRequestBodyException extends InvalidRequestStateException {

    public NullRequestBodyException() {
        super("Request body cannot be null");
    }
}
