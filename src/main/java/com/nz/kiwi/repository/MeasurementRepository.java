package com.nz.kiwi.repository;

import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MeasurementRepository extends JpaRepository<Measurements, Long> {

    @Query("SELECT m FROM Measurements m WHERE m.healthCheck = :id")
    Optional<Measurements> getMeasurements(@Param("id") Long id);

    }
