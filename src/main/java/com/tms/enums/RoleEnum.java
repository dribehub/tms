package com.tms.enums;

import com.tms.entity.UserRole;

import java.util.Arrays;
import java.util.Optional;

public enum RoleEnum {

    USER(1),
    ADMIN(2);

    public final UserRole userRole;
    public final Integer id;

    RoleEnum(Integer id) {
        this.userRole = new UserRole(id, name());
        this.id = id;
    }

    public static Optional<UserRole> getRoleByName(String name) {
        return Arrays.stream(RoleEnum.values())
                .filter(re -> re.name().equals(name.toUpperCase()))
                .map(re -> re.userRole)
                .findFirst();
    }

    public static String[] names() {
        return Arrays.stream(RoleEnum.values())
                .map(RoleEnum::name).toArray(String[]::new);
    }
}
