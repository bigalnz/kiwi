package com.nz.kiwi.service;

import com.nz.kiwi.view.LengthMeasurementsDto;

public interface LengthMeasurementsService {

    LengthMeasurementsDto getNewestLengthsByBirdId(Long id);

}
