package com.tms.repository;

import com.tms.entity.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripStatusRepository extends JpaRepository<TripStatus, Integer> {

    Optional<TripStatus> findByName(String name);
}
