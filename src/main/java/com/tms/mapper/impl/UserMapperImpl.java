package com.tms.mapper.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.mapper.RoleMapper;
import com.tms.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {

    private final RoleMapper roleMapper;

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) return null;
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setCreatedAt(dto.getCreatedAt());
        if (dto.getUserRoles() != null) {
            entity.setUserRoles(dto.getUserRoles()
                    .stream().map(roleMapper::toEntity)
                    .collect(Collectors.toList()));
        }
        return entity;
    }

    @Override
    public UserDto toDto(User entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setCreatedAt(entity.getCreatedAt());
        if (entity.getUserRoles() != null) {
            dto.setUserRoles(entity.getUserRoles()
                    .stream().map(roleMapper::toDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}
