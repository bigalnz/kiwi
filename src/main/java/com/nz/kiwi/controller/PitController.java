package com.nz.kiwi.controller;


import com.nz.kiwi.implementation.HealthCheckServiceImpl;
import com.nz.kiwi.implementation.PitServiceImpl;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.view.PitDto;
import com.nz.kiwi.view.PitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/pits")
@RequiredArgsConstructor
public class PitController {

    @Autowired
    private final PitServiceImpl pitService;

    @Autowired
    private final HealthCheckServiceImpl healthCheckService;

    @Autowired
    private PitMapper pitMapper;

// GET ONE PIT
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pit>> find(@PathVariable Long id) {
        System.out.println("test again newest ddd");
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(pitService.findById(id));
    }

// SAVE ONE PIT WITH POST
    @PostMapping(value = "/")
    ResponseEntity<PitDto> newPIT(@RequestBody PitDto pitDto) {
        Pit createdPit = pitMapper.toEntity(pitDto);
        HealthCheck healthCheck = healthCheckService.get(pitDto.getHealthCheckId()).orElseThrow(() -> new EntityNotFoundException("error Health CHeck Id not found"));
        createdPit.setHealthCheck(healthCheck);
        pitService.savePIT(createdPit);
        return ResponseEntity.ok().body(pitDto);
    }
}
