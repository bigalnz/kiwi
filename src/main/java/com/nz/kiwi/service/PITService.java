package com.nz.kiwi.service;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.PIT;

import java.util.Collection;

public interface PITService {

    PIT create(PIT pit);
    Collection<PIT> list();
    PIT get(Long id);
    PIT update(PIT pit);
    void delete(Long id);
}
