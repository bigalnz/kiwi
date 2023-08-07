package com.nz.kiwi.service;
import com.nz.kiwi.model.LengthMeasurements;

import java.util.Optional;

public interface MeasurementsService {

    Optional<LengthMeasurements> getMeasurements(Long id);

}
