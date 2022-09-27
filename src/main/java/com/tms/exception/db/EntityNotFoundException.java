package com.tms.exception.db;

import com.tms.exception.CustomRuntimeException;

public class EntityNotFoundException extends CustomRuntimeException {

    private static final String
            GENERIC_FORMAT = "Failed to find requested entity",
            NAME_FORMAT = "Could not find %s specified",
            ID_FORMAT = "Could not find %s with id %d",
            USERNAME_FORMAT = "Could not find %s with username '%s'";

    public EntityNotFoundException() {
        super(GENERIC_FORMAT);
    }

    public EntityNotFoundException(Class<?> clazz) {
        super(String.format(NAME_FORMAT, clazz.getSimpleName()));
    }

    public EntityNotFoundException(Class<?> clazz, Integer id) {
        super(String.format(ID_FORMAT, clazz.getSimpleName(), id));
    }

    public EntityNotFoundException(Class<?> clazz, String username) {
        super(String.format(USERNAME_FORMAT, clazz.getSimpleName(), username));
    }
}
