package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long> {

    @Query("SELECT h FROM HealthCheck h LEFT JOIN FETCH h.tasks WHERE h.id = :id")
    Optional<HealthCheck> getFullHealthCheck(@Param("id") Long id);

    @Query("SELECT h FROM HealthCheck h WHERE h.id = :id")
    Optional <HealthCheck> getOneManually(@Param("id") Long id);

    List<HealthCheck> findAllHealthChecksBy();

    }


