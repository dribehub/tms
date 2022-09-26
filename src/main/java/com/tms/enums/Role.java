package com.tms.enums;

import com.tms.entity.UserRole;

public enum Role {

    USER(new UserRole(1, "USER")),
    ADMIN(new UserRole(2, "ADMIN"));

    public final UserRole value;

    Role(UserRole value) {
        this.value = value;
    }
}
