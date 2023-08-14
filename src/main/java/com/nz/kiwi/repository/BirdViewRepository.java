package com.nz.kiwi.repository;

import com.blazebit.persistence.spring.data.repository.EntityViewRepository;

public interface BirdViewRepository extends EntityViewRepository<BirdView, Long> {
    BirdView findById(Long id);
}