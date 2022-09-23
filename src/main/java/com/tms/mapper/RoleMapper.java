package com.tms.mapper;

import com.tms.dto.UserRoleDto;
import com.tms.entity.UserRole;

public interface RoleMapper {

    UserRole toEntity(UserRoleDto dto);
    UserRoleDto toDto(UserRole entity);
}
