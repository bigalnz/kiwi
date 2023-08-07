package com.nz.kiwi.implementation;

import com.nz.kiwi.model.LengthMeasurements;
import com.nz.kiwi.repository.MeasurementRepository;
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

    public Optional<LengthMeasurements> getMeasurements(Long id)  {
        return measurementRepository.getMeasurements(id);
    }

}
