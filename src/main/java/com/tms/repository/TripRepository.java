package com.tms.repository;

import com.tms.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {

    @Query("SELECT t FROM Trip t " +
            "JOIN FETCH t.createdBy u " +
            "WHERE u.id = :id")
    List<Trip> findByUserCreatedId(Integer id);
}
