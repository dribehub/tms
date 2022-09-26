package com.tms.mapper;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.security.UserDetailsImpl;

public interface UserMapper {

    User toEntity(UserDto dto);
    UserDto toDto(User entity);
    UserDetailsImpl toDetails(User user);
    User toUser(UserDetailsImpl details);
}
