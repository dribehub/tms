package com.tms.service;

import com.tms.dto.UserDto;
import org.springframework.security.core.Authentication;

public interface AuthService {

    Authentication getAuthentication();
    UserDto getLoggedInUserDto();
    Integer getLoggedInUserId();
    boolean isLoggedInUserAdmin();
}
