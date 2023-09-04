package com.nz.kiwi.implementation;

import com.nz.kiwi.model.ChickTimer;
import com.nz.kiwi.repository.ChickTimerRepository;
import com.nz.kiwi.service.ChickTimerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ChickTimerServiceImpl implements ChickTimerService {

    @Autowired
    ChickTimerRepository chickTimerRepository;

    public List<ChickTimer> findAll() {
        return chickTimerRepository.findAll();
    }
}
