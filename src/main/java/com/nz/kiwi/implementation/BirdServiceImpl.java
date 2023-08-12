package com.nz.kiwi.implementation;

import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.view.*;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.service.BirdService;
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
    private final HealthCheckRepository healthCheckRepository;

    public List<BirdInfo> findBirdById(Long id) {
        return birdRepository.findBirdById(id);
    }

    public BirdSummaryDto findBirdDTO(Long id) {
        return birdRepository.findBirdDTO(id);
    }

    public List<BirdSummaryDto> listBirdDTO() {
        List<BirdSummaryDto> test = birdRepository.listBirdDTO();
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

    public Optional<BirdTestDto> testBirdTestDto(Long id) {
        System.out.println("test");
        Optional<BirdTestDto> test = birdRepository.testBirdTestDto(id);
        return birdRepository.testBirdTestDto(id);
    }

    // CREATE BIRD DETAILS DTO FROM QUERIES
    public BirdDetailsDto getBirdDetailsDto(Long id) {
        BirdDetailsDto birdDetailsDto = new BirdDetailsDto();
        birdDetailsDto.setBird(birdRepository.findBirdDTO(id));
        birdDetailsDto.setMostRecentHealthCheck(healthCheckRepository.getHealthCheckDtoByBirdId(id).getCatchDateTime());
        return birdDetailsDto;
    }


}
