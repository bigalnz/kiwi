package com.nz.kiwi.service;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Measurements;

import java.util.Optional;

public interface MeasurementsService {

    Optional<Measurements> getMeasurements(Long id);

}
