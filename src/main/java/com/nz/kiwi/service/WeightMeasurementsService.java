package com.nz.kiwi.service;

import com.nz.kiwi.view.WeightMeasurementsDto;

import java.util.List;

public interface WeightMeasurementsService {

    WeightMeasurementsDto getNewestWeightsByBirdId(Long id);

}
