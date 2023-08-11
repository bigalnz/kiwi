package com.nz.kiwi.implementation;

import com.nz.kiwi.model.WeightMeasurements;
import com.nz.kiwi.repository.WeightMeasurementsRepository;
import com.nz.kiwi.service.WeightMeasurementsService;
import com.nz.kiwi.view.WeightDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class WeightMeasurementsServiceImpl implements WeightMeasurementsService {

    private final WeightMeasurementsRepository  weightMeasurementsRepository;

    public List<WeightDto> getWeightMeasurementsByBirdId(Long id) {
        return weightMeasurementsRepository.getWeightMeasurementsByBirdId(id);
    };

}
