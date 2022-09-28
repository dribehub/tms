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
    public List<UserDto> getAll(Boolean isActive, Boolean isApproved) {
        return mapper.toDtos(repository.findAll(isActive, isApproved));
    }

    @Override
    public UserDto getById(Integer id) {
        return mapper.toDto(safeFindById(id));
    }

    @Override
    public UserDto register(UserDto user) {

        if (repository.isEmailTaken(user.getEmail()))
            throw new EmailTakenException(user.getEmail());
        if (repository.isUsernameTaken(user.getUsername()))
            throw new UsernameTakenException(user.getUsername());

        validatePasswordConstraints(user.getPassword());

        user.setPassword(encoder.encode(user.getPassword()));

        if (user.getRoles() == null || user.getRoles().isEmpty())
            user.setRoleAsUser();

        return mapper.toDto(repository.save(mapper.toEntity(user)));
    }

    private void validatePasswordConstraints(String password) {
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
    public UserDto update(Integer id, UserDto updated) {

        UserDto existing = getById(id);
        String username = updated.getUsername();
        String email = updated.getEmail();
        String password = updated.getPassword();

        if (username != null && !username.equals(existing.getUsername())) {
            if (repository.isUsernameTaken(username))
                throw new UsernameTakenException(username);
            existing.setUsername(username);
        }

        if (email != null && !email.equals(existing.getEmail())) {
            if (repository.isEmailTaken(email))
                throw new EmailTakenException(email);
            existing.setEmail(email);
        }

        if (password != null) {
            validatePasswordConstraints(password);
            existing.setPassword(encoder.encode(password));
        }

        if (updated.getRoles() != null)
            existing.setRoles(updated.getRoles());

        if (updated.getIsApproved() != null)
            existing.setIsApproved(updated.getIsApproved());

        if (updated.getIsActive() != null)
            existing.setIsActive(updated.getIsActive());

        return mapper.toDto(repository.save(mapper.toEntity(existing)));
    }

    @Override
    public UserDto setApprovedById(Integer id, boolean isApproved) {
        User user = safeFindById(id);
        user.setIsApproved(isApproved);
        return mapper.toDto(repository.save(user));
    }

    @Override
    public UserDto deleteById(Integer id) {
        User deleted = safeFindById(id);
        deleted.setIsActive(false);
        return mapper.toDto(repository.save(deleted));
    }

    @Override
    public UserDto restoreById(Integer id) {
        User restored = safeFindById(id);
        restored.setIsActive(true);
        return mapper.toDto(repository.save(restored));
    }
}
