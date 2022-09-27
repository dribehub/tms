package com.tms.repository;

import com.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.isActive = TRUE")
    List<User> findActive();

    @Query("SELECT u FROM User u WHERE u.isActive = FALSE")
    List<User> findNotActive();

    @Query("SELECT u FROM User u WHERE u.isApproved = TRUE")
    List<User> findApproved();

    @Query("SELECT u FROM User u WHERE u.isApproved = FALSE")
    List<User> findNotApproved();

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.username = :username")
    boolean isUsernameTaken(String username);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean isEmailTaken(String email);
}
