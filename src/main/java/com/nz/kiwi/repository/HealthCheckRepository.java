package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface HealthCheckRepository extends JpaRepository <HealthCheck, Long> {

    @Query("select hc from HealthCheck hc where hc.bird.id = :birdId")
    Collection<HealthCheck> findHealthCheckByBirdId(@Param("birdId") Long id);

    @Query(value = "SELECT TOP 1 * FROM HEALTH_CHECK WHERE BIRD_ID=:id ORDER BY CATCH_DATE DESC;", nativeQuery = true)
    HealthCheck findNewestHealthCheckByBirdId(@Param("id")Long id);
}
