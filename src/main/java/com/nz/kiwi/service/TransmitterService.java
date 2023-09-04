package com.nz.kiwi.service;

import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;

import java.util.Optional;

public interface TransmitterService {

    Optional<Transmitter> findById(Long id);

    Transmitter save(Transmitter transmitter);

}
