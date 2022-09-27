package com.tms.exception.db;

import com.tms.exception.CustomRuntimeException;

public class EntityNotUniqueException extends CustomRuntimeException {

    private static final String
            GENERIC_FORMAT = "This record already exists. Could not create duplicate records",
            NAME_FORMAT = "%s already exists. Could not create duplicate records",
            ID_FORMAT = "%s with id %d already exists. Could not create duplicate records";

    public EntityNotUniqueException() {
        super(GENERIC_FORMAT);
    }

    public EntityNotUniqueException(Class<?> clazz) {
        super(String.format(NAME_FORMAT, clazz.getSimpleName()));
    }

    public EntityNotUniqueException(Class<?> clazz, Integer id) {
        super(String.format(ID_FORMAT, clazz.getSimpleName(), id));
    }
}
