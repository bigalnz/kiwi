package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.PIT;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.PITRepository;
import com.nz.kiwi.service.BirdService;
import com.nz.kiwi.service.PITService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PITServiceImpl implements PITService {

    private final PITRepository pitRepository;

    @Override
    public PIT create(PIT pit) {
        log.info("Saving new pit: {}", pit.getCode() );
        return pitRepository.save(pit);
    }

    @Override
    public Collection<PIT> list() {
        log.info("Finding all pits");
        return pitRepository.findAll();
    }

    @Override
    public PIT get(Long id) {
        return pitRepository.findById(id).get();
    }

    @Override
    public PIT update(PIT pit) {
        return null;
    }

    @Override
    public void delete(Long id) {
        log.info("About to delete pit : {}", id);
        pitRepository.deleteById(id);
    }
}
