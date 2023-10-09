package com.nz.kiwi.implementation;

import com.nz.kiwi.error.BirdAlreadyExistsException;
import com.nz.kiwi.error.DatabaseUniqueConstraintException;
import com.nz.kiwi.error.EntityNotFoundException;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.*;
import com.nz.kiwi.mapper.BirdMapper;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.service.BirdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
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

    public BirdCreateDto updateBird(BirdCreateDto updateBirdDto, Long id) {
        Bird bird = birdRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bird with " + id + " not found"));
        try {
            birdMapper.partialUpdate(updateBirdDto, bird);
            birdRepository.save(bird);
            return birdMapper.toDto(bird);
        } catch (DataIntegrityViolationException e) {
            throw new BirdAlreadyExistsException("Bird with name already exist");
        }
    }

/*    public BirdCreateDto updateBird(BirdCreateDto updateBirdDto, Long id) {
        // Get bird or throw exception
        Bird bird = birdRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bird with " + id + " not found"));
        // Check property to be updated isn't name, and if so - check uniqueness
        // If names are same - run update || diff but passes uniqueness
        boolean samename = updateBirdDto.getName().equalsIgnoreCase(bird.getName());
        if (samename || !samename && !birdRepository.existsByName(updateBirdDto.getName())) {
            birdMapper.partialUpdate(updateBirdDto, bird);
            birdRepository.save(bird);
            return birdMapper.toDto(bird);
        } else {
            // Name exists in db - throw error and refuse update
            throw new DatabaseUniqueConstraintException("Bird with name " + updateBirdDto.getName() + " already exists");
        }
    }*/

    @Override
    public Bird createBird(BirdCreateDto createBirdDto) {
        if (!birdRepository.existsByName(createBirdDto.getName())) {
            return birdRepository.save(birdMapper.toEntity(createBirdDto));
        } else {
            throw new DatabaseUniqueConstraintException("Bird with name " + createBirdDto.getName() + " already exists.");
        }
    }


    public BirdCreateDto updateBird2(BirdCreateDto updateBirdDto, Long id) {
        // Get bird or throw exception
        Bird bird = birdRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bird with " + id + " not found"));
        // Check property to be updated isn't name, and if so - check uniqueness
        // If names are same - run update || diff but passes uniqueness
        boolean samename = updateBirdDto.getName().equalsIgnoreCase(bird.getName());
        if (samename || !samename && !birdRepository.existsByName(updateBirdDto.getName())) {
            birdMapper.partialUpdate(updateBirdDto, bird);
            birdRepository.save(bird);
            return birdMapper.toDto(bird);
        } else {
            // Name exists in db - throw error and refuse update
            throw new DatabaseUniqueConstraintException("Bird with name " + updateBirdDto.getName() + " already exists");
        }
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
