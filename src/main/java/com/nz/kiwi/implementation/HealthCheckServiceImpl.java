package com.nz.kiwi.implementation;

import com.nz.kiwi.dto.HealthCheckListDTO;
import com.nz.kiwi.dto.HealthCheckViewDTO;
import com.nz.kiwi.dto.TransmitterDTO;
import com.nz.kiwi.dto.TransmitterOnHealthCheckDTO;
import com.nz.kiwi.mapper.HealthCheckMapper;
import com.nz.kiwi.mapper.TransmitterMapper;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Transmitter;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.repository.TransmitterRepository;
import com.nz.kiwi.service.HealthCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class HealthCheckServiceImpl implements HealthCheckService {

    private final HealthCheckRepository healthCheckRepository;
    private final HealthCheckMapper healthCheckMapper;
    private final TransmitterRepository transmitterRepository;
    private final TransmitterMapper transmitterMapper;
    private final BirdRepository birdRepository;


    @Override
    public HealthCheck findNewestHealthCheckByBirdId(Long id) {
        return healthCheckRepository.findNewestHealthCheckByBirdId(id);
    }

    @Override
    public Collection<HealthCheckListDTO> listHealthCheckDTO() {
        List<HealthCheck> listHealthCheck = healthCheckRepository.findAll();
        List<HealthCheckListDTO> listHealthCheckListDTO = new ArrayList<>();
        for (HealthCheck hc: listHealthCheck ) {
            listHealthCheckListDTO.add(healthCheckMapper.healthCheckToHealthCheckListDTO(hc));
        }
        return listHealthCheckListDTO;
    }

    @Override
    public HealthCheckViewDTO getHealthCheckViewDTO(Long id) {
        HealthCheck healthCheck = get(id);
        Transmitter transmitter = transmitterRepository.getByHealthCheckId(id);
        HealthCheckViewDTO healthCheckViewDTO;
        TransmitterOnHealthCheckDTO transmitterOnHealthCheckDTO;
        //healthCheckViewDTO = healthCheckMapper.healthCheckToHealthCheckViewDTOTest(healthCheck, transmitter);
        Bird bird = healthCheck.getBird();
        healthCheckViewDTO = healthCheckMapper.healthCheckToHealthCheckViewDTO(healthCheck, transmitter);
        transmitterOnHealthCheckDTO = transmitterMapper.transmitterToTransmitterOnHealthCheckDTO(transmitter);
        healthCheckViewDTO.setTransmitter(transmitterOnHealthCheckDTO);
        return healthCheckViewDTO;
    }

    @Override
    public Collection<HealthCheck> getHealthCheckByBirdId(Long id) {
        log.info("Getting List of Health Checks by Bird id");
        return healthCheckRepository.findHealthCheckByBirdId(id);
    }

    @Override
    public HealthCheck healthCheckWithWeights(Long id) {
        log.info("Getting a Health Check with Weight");
        HealthCheck healthCheck = healthCheckRepository.getById(id);
        return healthCheck;
    }

    @Override
    public HealthCheck create(HealthCheck healthCheck) {
        log.info("Saving new health check: {}", healthCheck.getId() );
        return healthCheckRepository.save(healthCheck);
    }

    @Override
    public Collection<HealthCheck> list() {
        log.info("Finding all health checks");
        return healthCheckRepository.findAll();
    }

    @Override
    public HealthCheck get(Long id) {
        log.info("Getting a single Health Check");
        return healthCheckRepository.getById(id);
    }

    @Override
    public HealthCheck update(HealthCheck healthCheck) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
