package com.nz.kiwi.repository;

import com.nz.kiwi.model.LengthMeasurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MeasurementRepository extends JpaRepository<LengthMeasurements, Long> {

    @Query("SELECT m FROM LengthMeasurements m WHERE m.healthCheck = :id")
    Optional<LengthMeasurements> getMeasurements(@Param("id") Long id);

    }
