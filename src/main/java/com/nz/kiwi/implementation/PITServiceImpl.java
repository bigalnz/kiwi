package com.nz.kiwi.implementation;

import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.PIT;
import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.repository.PITRepository;
import com.nz.kiwi.service.HealthCheckService;
import com.nz.kiwi.service.PITService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PITServiceImpl implements PITService {
    private final PITRepository pitRepository;

    @Override
    public Optional<PIT> findById(Long id) {
        return pitRepository.findById(id);
    }


    public PIT savePIT(PIT pit) {
        return pitRepository.save(pit);
    }
}
