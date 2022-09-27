package com.tms.service.impl;

import com.tms.dto.UserDto;
import com.tms.entity.User;
import com.tms.exception.db.EntityNotFoundException;
import com.tms.exception.validation.user.*;
import com.tms.mapper.UserMapper;
import com.tms.repository.UserRepository;
import com.tms.service.UserService;
import com.tms.util.PatternUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    private User safeFindById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(User.class, id));
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public List<UserDto> getActive() {
        return mapper.toDtos(repository.findActive());
    }

    @Override
    public List<UserDto> getNotActive() {
        return mapper.toDtos(repository.findNotActive());
    }

    @Override
    public List<UserDto> getApproved() {
        return mapper.toDtos(repository.findApproved());
    }

    @Override
    public List<UserDto> getNotApproved() {
        return mapper.toDtos(repository.findNotApproved());
    }

    @Override
    public UserDto getById(Integer id) {
        return mapper.toDto(safeFindById(id));
    }

    @Override
    public UserDto register(UserDto user) {
        validateNewUser(user);
        user.setPassword(encoder.encode(user.getPassword()));
        if (user.getRoles() == null || user.getRoles().isEmpty())
            user.setRoleAsUser();
        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    private void validateNewUser(UserDto user) {
        if (!PatternUtils.isEmail(user.getEmail()))
            throw new InvalidEmailFormatException(user.getEmail());
        if (!PatternUtils.isUsername(user.getUsername()))
            throw new InvalidUsernameException(user.getUsername());
        if (repository.isEmailTaken(user.getEmail()))
            throw new EmailTakenException(user.getEmail());
        if (repository.isUsernameTaken(user.getUsername()))
            throw new UsernameTakenException(user.getUsername());
        validateNewPassword(user.getPassword());
    }

    private void validateNewPassword(String password) {
        if (password.length() < 8)
            throw WeakPasswordException.tooShort();
        if (!PatternUtils.containsUppercase(password))
            throw WeakPasswordException.noUppercase();
        if (!PatternUtils.containsDigits(password))
            throw WeakPasswordException.noDigit();
        if (!PatternUtils.containsSymbols(password))
            throw WeakPasswordException.noSymbol();
    }

    @Override
    public UserDto update(UserDto user) {
        safeFindById(user.getId());
        if (user.getPassword() != null)
            user.setPassword(encoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    @Override
    public UserDto setApprovedById(Integer id, boolean isApproved) {
        User user = safeFindById(id);
        user.setApproved(isApproved);
        return mapper.toDto(repository.save(user));
    }

    @Override
    public UserDto deleteById(Integer id) {
        User deleted = safeFindById(id);
        deleted.setActive(false);
        return mapper.toDto(repository.save(deleted));
    }

    @Override
    public UserDto restoreById(Integer id) {
        User restored = safeFindById(id);
        restored.setActive(true);
        return mapper.toDto(repository.save(restored));
    }
}
