package com.nz.kiwi.service;

import com.nz.kiwi.model.LengthMeasurements;
import com.nz.kiwi.view.LengthMeasurementsDto;

public interface LengthMeasurementsService {

    LengthMeasurementsDto getNewestLengthsByBirdId(Long id);

    LengthMeasurements save(LengthMeasurements lengthMeasurements);

}
