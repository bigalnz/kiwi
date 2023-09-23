package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.CustomBirdRepository;
import com.nz.kiwi.repository.CustomBirdService;
import com.nz.kiwi.service.BirdService;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.Test;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomBirdServiceImpl implements CustomBirdService {

    private final CustomBirdRepository customBirdRepository;

    @Override
    public BirdDetailsDto customQuery(Long id) {
        return customBirdRepository.customQuery(id);
    }

    @Override
    public BirdSummaryDto customQuery1(Long id) {
        return null;
    }

    @Override
    public BirdSummaryDto customQuery2(Long id) {
        return null;
    }

    @Override
    public Test customQuery3(Long id) {
        return null;
    }

    @Override
    public Object customQuery4(Long id) {
        return null;
    }

    @Override
    public Object customQuery5(Long id) {
        return null;
    }
}
