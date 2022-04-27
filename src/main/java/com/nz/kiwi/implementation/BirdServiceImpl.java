package com.nz.kiwi.implementation;

import com.nz.kiwi.dto.*;
import com.nz.kiwi.mapper.BirdMapper;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.service.BirdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;
    private final BirdMapper birdMapper;
    private final HealthCheckRepository healthCheckRepository;

    @Override
    public Bird getBirdTextXML() {
        return birdRepository.getBirdTestXML();
    }

    @Override
    public BirdDTO getBirdDTO(Long id) {
        return birdRepository.getBirdDTO(id);
    }

    @Override
    public Collection<BirdDTO> getBirdListDTO() {
        return birdRepository.getBirdListDTO();
    }

    @Override
    public BirdViewDTO getBirdViewDTO(Long id){
        return birdRepository.getBirdViewDTO(id);
    }

    @Override
    public Bird create(Bird bird) {
        log.info("Saving new bird: {}", bird.getName() );
        return birdRepository.save(bird);
    }

    @Override
    public Collection<Bird> list() {
        log.info("Finding all birds");
        return birdRepository.findAll();
    }

    @Override
    public Bird get(Long id) {
        return birdRepository.findById(id).get();
    }

    @Override
    public Bird update(Bird bird) {
        return null;
    }

    @Override
    public void delete(Long id) {
        log.info("About to delete bird : {}", id);
        Bird bird = new Bird();
        if (birdRepository.existsById(id)) {
             birdRepository.deleteById(id);
        }
    }
}
