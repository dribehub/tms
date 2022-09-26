package com.tms.mapper.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.mapper.UserMapper;
import com.tms.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) return null;
        User entity = new User();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUserRoles(dto.getUserRoles());
        return entity;
    }

    @Override
    public UserDetailsImpl toDetails(User entity) {
        if (entity == null) return null;
        UserDetailsImpl details = new UserDetailsImpl();
        details.setId(entity.getId());
        details.setUsername(entity.getUsername());
        details.setEmail(entity.getEmail());
        details.setPassword(entity.getPassword());
        details.setAuthorities(entity.getUserRoles());
        return details;
    }

    @Override
    public UserDto toDto(User entity) {
        if (entity == null) return null;
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setUserRoles(entity.getUserRoles());
        return dto;
    }

    @Override
    public UserDetailsImpl toDetails(UserDto dto) {
        if (dto == null) return null;
        UserDetailsImpl details = new UserDetailsImpl();
        details.setId(dto.getId());
        details.setUsername(dto.getUsername());
        details.setEmail(dto.getEmail());
        details.setPassword(dto.getPassword());
        details.setAuthorities(dto.getUserRoles());
        return details;
    }
}
