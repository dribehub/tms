package com.tms.service.impl;

import com.tms.dto.UserDto;
import com.tms.exception.user.EmailTakenException;
import com.tms.exception.user.UsernameTakenException;
import com.tms.exception.user.WeakPasswordException;
import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.service.UserService;
import com.tms.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto register(UserDto user) {
        validateNewUser(user);
        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    @Override
    public void validateNewUser(UserDto user) {
        if (repository.isEmailTaken(user.getEmail()))
            throw new EmailTakenException(user.getEmail());
        if (repository.isUsernameTaken(user.getUsername()))
            throw new UsernameTakenException(user.getUsername());
        validateNewPassword(user.getPassword());

    }

    private void validateNewPassword(String password) {
        if (password.length() < 8)
            throw WeakPasswordException.tooShort();
        StringUtils stringUtils = new StringUtils(password);
        if (!stringUtils.containsUppercase())
            throw WeakPasswordException.noUppercase();
        if (!stringUtils.containsDigits())
            throw WeakPasswordException.noDigit();
        if (!stringUtils.containsSymbols())
            throw WeakPasswordException.noSymbol();
    }
}
