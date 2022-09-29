package com.tms.service;

import com.tms.dto.UserDto;
import com.tms.enums.RoleEnum;
import org.springframework.security.core.Authentication;

public interface AuthService {

    Authentication getAuthentication();

    UserDto getPrinciple();

    Integer getPrincipleId();

    boolean isPrincipleAdmin();

    boolean isPrincipleUser();

    boolean isPrincipleOfRole(RoleEnum role);
}
