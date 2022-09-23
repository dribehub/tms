package com.tms.mapper;

import com.tms.dto.UserDto;
import com.tms.entity.User;

public interface UserMapper {

    User toEntity(UserDto dto);
    UserDto toDto(User entity);
}
