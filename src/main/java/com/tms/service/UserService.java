package com.tms.service;

import com.tms.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    UserDto register(UserDto user);

    void validateNewUser(UserDto user);
}
