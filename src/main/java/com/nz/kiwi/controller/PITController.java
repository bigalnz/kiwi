package com.nz.kiwi.controller;

import com.nz.kiwi.implementation.HealthCheckServiceImpl;
import com.nz.kiwi.implementation.PITServiceImpl;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.PIT;
import com.nz.kiwi.repository.PITRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pits")
@RequiredArgsConstructor
public class PITController {

    @Autowired
    private final PITServiceImpl pitService;

// GET ONE PIT
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PIT>> find(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(pitService.findById(id));
    }

// SAVE ONE PIT
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    PIT newPIT(@RequestBody PIT pit) {
        return pitService.savePIT(pit);
    }
}
