package com.nz.kiwi.service;

import com.nz.kiwi.dto.HealthCheckListDTO;
import com.nz.kiwi.dto.HealthCheckViewDTO;
import com.nz.kiwi.model.HealthCheck;
import java.util.Collection;

public interface HealthCheckService {
    HealthCheck create(HealthCheck healthCheck);
    Collection<HealthCheck> list();
    HealthCheck get(Long id);
    HealthCheck update(HealthCheck healthCheck);
    Boolean delete(Long id);
    Collection<HealthCheck> getHealthCheckByBirdId(Long id);
    HealthCheck healthCheckWithWeights(Long id);
    Collection<HealthCheckListDTO> listHealthCheckDTO();
    HealthCheckViewDTO getHealthCheckViewDTO(Long id);
    HealthCheck findNewestHealthCheckByBirdId(Long id);
}
