package com.nz.kiwi.service;
import com.nz.kiwi.model.HealthCheck;

import java.util.List;
import java.util.Optional;

public interface HealthCheckService {

    Optional<HealthCheck> get(Long id);
    HealthCheck save(HealthCheck healthCheck);
    Optional<HealthCheck> getOneManually(Long id);

    List<HealthCheck> findAllHealthChecksBy();
}
