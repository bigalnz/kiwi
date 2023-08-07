package com.nz.kiwi.service;
import com.nz.kiwi.model.Pit;

import java.util.Optional;

public interface PitService {

    Optional<Pit> findById(Long id);
    public Pit savePIT(Pit pit);

}
