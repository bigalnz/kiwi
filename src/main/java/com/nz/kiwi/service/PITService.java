package com.nz.kiwi.service;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.PIT;

import java.util.Optional;

public interface PITService {

    Optional<PIT> findById(Long id);
    public PIT savePIT(PIT pit);
}
