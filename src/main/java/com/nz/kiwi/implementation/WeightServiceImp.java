package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Weight;
import com.nz.kiwi.repository.WeightRepository;
import com.nz.kiwi.service.WeightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class WeightServiceImp implements WeightService {

    private final WeightRepository weightRepository;

    @Override
    public Weight create(Weight weight) {
        return null;
    }

    @Override
    public Weight get(Long Id) {
        return null;
    }

    @Override
    public Collection<Weight> list() {
        return null;
    }

    @Override
    public Weight update(Weight weight) {
        return null;
    }

    @Override
    public Boolean delete(Long Id) {
        return null;
    }
}
