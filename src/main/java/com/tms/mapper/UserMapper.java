package com.tms.mapper;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.dto.details.UserDetailsImpl;

public interface UserMapper {

    User toEntity(UserDto dto);
    UserDetailsImpl toDetails(User entity);

    UserDto toDto(User entity);
    UserDetailsImpl toDetails(UserDto dto);
}
