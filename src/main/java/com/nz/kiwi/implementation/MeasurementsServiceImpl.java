package com.nz.kiwi.implementation;

import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Measurements;
import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.repository.MeasurementRepository;
import com.nz.kiwi.service.HealthCheckService;
import com.nz.kiwi.service.MeasurementsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MeasurementsServiceImpl implements MeasurementsService {
    private final MeasurementRepository measurementRepository;

    public Optional<Measurements> getMeasurements(Long id)  {
        return measurementRepository.getMeasurements(id);
    }

}
