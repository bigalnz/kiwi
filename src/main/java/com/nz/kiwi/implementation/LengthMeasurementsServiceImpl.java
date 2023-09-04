package com.nz.kiwi.implementation;

import com.nz.kiwi.model.LengthMeasurements;
import com.nz.kiwi.repository.LengthMeasurementRepository;
import com.nz.kiwi.service.LengthMeasurementsService;
import com.nz.kiwi.view.LengthMeasurementsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LengthMeasurementsServiceImpl implements LengthMeasurementsService {

    private final LengthMeasurementRepository lengthMeasurementsRepository;

    public LengthMeasurementsDto getNewestLengthsByBirdId(Long id) {
        return lengthMeasurementsRepository.getNewestLengthsByBirdId(id);
    }

    public LengthMeasurements save(LengthMeasurements lengthMeasurements) {
        return lengthMeasurementsRepository.save(lengthMeasurements);
    }
}
