package com.nz.kiwi.implementation;

import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.service.HealthCheckService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class HealthCheckServiceImpl implements HealthCheckService {
    private final HealthCheckRepository healthCheckRepository;

    @Autowired
    private EntityManager entityManager;
    @Override
    public Optional<HealthCheck> get(Long id) {
        return healthCheckRepository.findById(id);
    }

    @Override
    public HealthCheck save(HealthCheck healthCheck) {
        return healthCheckRepository.save(healthCheck);
    }

    @Override
    public Optional<HealthCheck> getOneManually(Long id) {
        return healthCheckRepository.getOneManually(id);
    }

    public Optional<HealthCheck> getFullHealthCheck(Long id)  {
        return healthCheckRepository.getFullHealthCheck(id);
    }

    public List<HealthCheck> findAllHealthChecksBy() {
        return healthCheckRepository.findAllHealthChecksBy();
    }
}
