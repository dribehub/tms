package com.tms.mapper.impl;

import com.tms.dto.UserRoleDto;
import com.tms.entity.UserRole;
import com.tms.mapper.RoleMapper;

import org.springframework.stereotype.Component;

@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public UserRole toEntity(UserRoleDto dto) {
        if (dto == null) return null;
        UserRole entity = new UserRole();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public UserRoleDto toDto(UserRole entity) {
        if (entity == null) return null;
        UserRoleDto dto = new UserRoleDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
