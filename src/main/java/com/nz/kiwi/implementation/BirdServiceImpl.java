package com.nz.kiwi.implementation;

import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDTO;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.service.BirdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;

    public List<BirdInfo> findBirdById(Long id) {
        return birdRepository.findBirdById(id);
    }

    public Optional<BirdSummaryDTO> findBirdDTO(Long id) {
        return birdRepository.findBirdDTO(id);
    }

    public List<BirdSummaryDTO> listBirdDTO() {
        List<BirdSummaryDTO> test = birdRepository.listBirdDTO();
        return birdRepository.listBirdDTO();
    }

    public List<BirdInfo> findAllBy() {
        return birdRepository.findAllBy();
    }

    public Optional<Bird> get(Long id) {
        return birdRepository.findById(id);
    }

    @Override
    public Bird saveBird(Bird bird) {
        return birdRepository.save(bird);
    }

    @Override
    public Optional<Bird> getBirdWithPIT(Long id) {
        return birdRepository.getBirdwithPIT(id);
    }


}
