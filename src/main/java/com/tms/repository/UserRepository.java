package com.tms.repository;

import com.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u " +
            "WHERE :isActive IS NULL OR u.isActive = :isActive " +
            "AND :isApproved IS NULL OR u.isApproved = :isApproved")
    List<User> findAll(Boolean isActive, Boolean isApproved);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.username = :username")
    boolean isUsernameTaken(String username);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean isEmailTaken(String email);
}
