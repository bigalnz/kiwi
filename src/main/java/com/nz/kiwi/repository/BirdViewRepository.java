package com.nz.kiwi.repository;

import com.blazebit.persistence.spring.data.repository.EntityViewRepository;
import com.nz.kiwi.model.BirdView;

public interface BirdViewRepository extends EntityViewRepository<BirdView, Long> {
    BirdView findById(Long id);
}