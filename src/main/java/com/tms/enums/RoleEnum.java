package com.tms.enums;

import com.tms.entity.UserRole;

public enum RoleEnum {

    USER(1),
    ADMIN(2);

    public final UserRole role;
    public final Integer id;

    RoleEnum(Integer id) {
        this.role = new UserRole(id, name());
        this.id = id;
    }
}
