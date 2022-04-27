package com.nz.kiwi.repository;

import com.nz.kiwi.model.Transmitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmitterRepository extends JpaRepository<Transmitter, Long> {

    Transmitter getByHealthCheckId(Long id);

}
