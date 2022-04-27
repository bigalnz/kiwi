package com.nz.kiwi.service;

import com.nz.kiwi.model.Weight;

import java.util.Collection;

public interface WeightService {

    Weight create(Weight weight);
    Weight get(Long Id);
    Collection<Weight> list();
    Weight update(Weight weight);
    Boolean delete(Long Id);
}
