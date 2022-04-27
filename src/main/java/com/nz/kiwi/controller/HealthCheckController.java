package com.nz.kiwi.controller;

import com.nz.kiwi.dto.HealthCheckListDTO;
import com.nz.kiwi.dto.HealthCheckViewDTO;
import com.nz.kiwi.implementation.HealthCheckServiceImpl;
import com.nz.kiwi.model.HealthCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/healthcheck")
@RequiredArgsConstructor
public class HealthCheckController {

    private final HealthCheckServiceImpl healthCheckService;

    @GetMapping("/{id}")
    public ResponseEntity<HealthCheckViewDTO> getHealthCheck(@PathVariable("id") Long id) {
        // test new getNewestHealthCheckByBirdId
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(healthCheckService.getHealthCheckViewDTO(id));
    }

    @GetMapping("/")
    public ResponseEntity<Collection<HealthCheckListDTO>> listHealthCheckDTO() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(healthCheckService.listHealthCheckDTO());
    }

    @GetMapping("/bybird/{id}")
    public ResponseEntity<Collection<HealthCheck>> getHealthCheckByBirdId(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(healthCheckService.getHealthCheckByBirdId(id));
    }
}
