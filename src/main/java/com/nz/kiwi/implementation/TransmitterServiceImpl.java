package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Transmitter;
import com.nz.kiwi.repository.TransmitterRepository;
import com.nz.kiwi.service.TransmitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TransmitterServiceImpl implements TransmitterService {
    private final TransmitterRepository transmitterRepository;

    @Override
    public Optional<Transmitter> findById(Long id) {
        return transmitterRepository.findById(id);
    }

    public Transmitter save(Transmitter transmitter) {
        return transmitterRepository.save(transmitter);
    }
}
