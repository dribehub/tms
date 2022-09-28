package com.tms.exception.db;

import com.tms.exception.CustomRuntimeException;

public class EntityNotFoundException extends CustomRuntimeException {

    private static final String
            GENERIC_FORMAT = "Failed to find requested entity",
            NAME_FORMAT = "Could not find %s specified",
            ID_FORMAT = "Could not find %s with id %d",
            KEY_VALUE_FORMAT = "Could not find %s with %s '%s'";

    public EntityNotFoundException() {
        super(GENERIC_FORMAT);
    }

    public EntityNotFoundException(Class<?> clazz) {
        super(String.format(NAME_FORMAT, clazz.getSimpleName()));
    }

    public EntityNotFoundException(Class<?> clazz, Integer id) {
        super(String.format(ID_FORMAT, clazz.getSimpleName(), id));
    }

    public EntityNotFoundException(Class<?> clazz, String property, String value) {
        super(String.format(KEY_VALUE_FORMAT, clazz.getSimpleName(), property, value));
    }

    public static EntityNotFoundException username(Class<?> clazz, String username) {
        return new EntityNotFoundException(clazz, "username", username);
    }

    public static EntityNotFoundException name(Class<?> clazz, String name) {
        return new EntityNotFoundException(clazz, "name", name);
    }
}
