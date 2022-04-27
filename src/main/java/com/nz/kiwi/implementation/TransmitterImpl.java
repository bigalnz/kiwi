package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Transmitter;
import com.nz.kiwi.repository.TransmitterRepository;
import com.nz.kiwi.service.TransmitterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TransmitterImpl implements TransmitterService {

    private final TransmitterRepository transmitterRepository;

    @Override
    public Transmitter get(Long id) {
        return transmitterRepository.getById(id);
    }

    @Override
    public Collection<Transmitter> list() {
        return transmitterRepository.findAll();
    }

    @Override
    public Transmitter getByHealthCheckId(Long id) {
        return transmitterRepository.getByHealthCheckId(id);
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Transmitter create(Transmitter transmitter) {
        return null;
    }
}
