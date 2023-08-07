package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Pit;
import com.nz.kiwi.repository.PitRepository;
import com.nz.kiwi.service.PitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PitServiceImpl implements PitService {
    private final PitRepository pitRepository;

    @Override
    public Optional<Pit> findById(Long id) {
        return pitRepository.findById(id);
    }


    public Pit savePIT(Pit pit) {
        return pitRepository.save(pit);
    }
}
