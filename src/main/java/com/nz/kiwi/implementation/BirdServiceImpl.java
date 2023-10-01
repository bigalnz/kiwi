package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.*;
import com.nz.kiwi.mapper.BirdMapper;
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
    private final BirdMapper birdMapper;


    @Override
    public Bird save(Bird bird) {
        return birdRepository.save(bird);
    }

    public BirdDetailsDto getBirdDetails(Long id) {
        return birdRepository.getBirdDetails(id);
    }

    @Override
    public BirdCreateDto getBirdById(Long id) {
        Bird bird = birdRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bird not found"));
        return birdMapper.toDto(bird);
    }

    @Override
    public BirdCreateDto createBird(BirdCreateDto createBirdDto) {
        Bird bird = birdMapper.toEntity(createBirdDto);
        Bird savedBird = birdRepository.save(bird);
        return birdMapper.toDto(savedBird);
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
