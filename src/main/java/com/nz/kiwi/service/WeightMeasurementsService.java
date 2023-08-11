package com.nz.kiwi.service;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.WeightMeasurements;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.BirdTestDto;
import com.nz.kiwi.view.WeightDto;

import java.util.List;
import java.util.Optional;

public interface WeightMeasurementsService {

    List<WeightDto> getWeightMeasurementsByBirdId(Long id);

}
