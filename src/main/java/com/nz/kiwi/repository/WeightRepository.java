package com.nz.kiwi.repository;

import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface WeightRepository extends JpaRepository<Weight, Long> {

    //@Query("select w from Weight w where w.healthCheck.id = :healthCheckId")
    //Collection<Weight> findWeightsByHealthCheckId(@Param("healthCheckId") Long id);

}
