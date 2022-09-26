package com.tms.service;

import com.tms.dto.UserDto;
import com.tms.security.UserDetailsImpl;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    UserDetailsImpl getDetailsByUsername(String username);

    UserDto register(UserDto user);

    void validateNewUser(UserDto user);
}
