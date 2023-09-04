package com.nz.kiwi.service;

import com.nz.kiwi.model.WeightMeasurements;
import com.nz.kiwi.view.WeightMeasurementsDto;


public interface WeightMeasurementsService {

    WeightMeasurementsDto getNewestWeightsByBirdId(Long id);

    WeightMeasurements save(WeightMeasurements weightMeasurements);

}
