package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.service.BirdService;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;
    // commented out during testing of BirdTests - may need to come back in
    //private final LengthMeasurementsServiceImpl lengthMeasurementsService;
    //private final WeightMeasurementsServiceImpl weightMeasurementsService;


/*    public BirdDetailsDto getBirdDetailsDtoById(Long id) {
        BirdDetailsDto birdDetailsDto =
        return birdDetailsDto;
    }*/


    @Override
    public Bird save(Bird bird) {
        return birdRepository.save(bird);
    }

    public List<BirdInfo> findBirdById(Long id) {
        return birdRepository.findBirdById(id);
    }

    public BirdSummaryDto findBirdSummaryDTO(Long id) {
        return birdRepository.findBirdSummaryDTO(id);
    }

    public List<BirdSummaryDto> listBirdSummaryDTO() {
        List<BirdSummaryDto> test = birdRepository.listBirdSummaryDTO();
        return birdRepository.listBirdSummaryDTO();
    }

    public List<BirdInfo> findAllBy() {
        return birdRepository.findAllBy();
    }

    public Optional<Bird> get(Long id) {
        return birdRepository.findById(id);
    }

    @Override
    public Optional<Bird> getBirdWithPIT(Long id) {
        return birdRepository.getBirdwithPIT(id);
    }


}
