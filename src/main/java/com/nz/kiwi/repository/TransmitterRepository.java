package com.nz.kiwi.repository;

import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransmitterRepository extends JpaRepository<Transmitter, Long> {

    Optional<Transmitter> findById(Long id);

}
