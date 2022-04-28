package com.nz.kiwi.controller;

import com.nz.kiwi.dto.*;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.implementation.HealthCheckServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/kiwi")
@RequiredArgsConstructor
public class KiwiController {


    @Autowired
    private final BirdServiceImpl birdService;
    @Autowired
    private final HealthCheckServiceImpl healthCheckService;

    // GET ONE BIRD WITH EXTENDED FIELDS
    @GetMapping("/{id}")
    public ResponseEntity<BirdViewDTO> getKiwi(@PathVariable("id") Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                //.body(birdService.getBirdDTO(id)); one summary bird
                .body(birdService.getBirdViewDTO(id));
    }

    // GET LIST OF BIRDS WITH SUMMARY FIELDS
    @GetMapping("/")
    public ResponseEntity<Collection<BirdDTO>> getListBirdDTO() { // was reutninging <BirdDashboardDTO>
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                //.body(birdService.listBirdDashboardDTO());
                .body(birdService.getBirdListDTO());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteKiwi(@PathVariable("id") Long id) {
        birdService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
