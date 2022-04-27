package com.nz.kiwi.service;

import com.nz.kiwi.model.Transmitter;

import java.util.Collection;

public interface TransmitterService {

    Transmitter get(Long id);
    Collection<Transmitter> list();
    Transmitter getByHealthCheckId(Long id);
    Boolean delete(Long id);
    Transmitter create(Transmitter transmitter);


}
