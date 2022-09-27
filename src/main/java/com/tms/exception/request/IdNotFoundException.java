package com.tms.exception.request;

import com.sun.jdi.request.InvalidRequestStateException;

public class IdNotFoundException extends InvalidRequestStateException {

    public IdNotFoundException() {
        super("Could not find id on request body");
    }
}
