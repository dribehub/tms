package com.tms.enums;

import com.tms.entity.UserRole;

import java.util.Arrays;

public enum RoleEnum {

    USER(1),
    ADMIN(2);

    public final UserRole role;
    public final Integer id;

    RoleEnum(Integer id) {
        this.role = new UserRole(id, name());
        this.id = id;
    }

    public static String[] getAllNames() {
        return Arrays.stream(RoleEnum.values())
                .map(RoleEnum::name)
                .toArray(String[]::new);
    }
}
