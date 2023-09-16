package com.nz.kiwi.controller;

//import com.nz.kiwi.model.BirdView;
//import com.nz.kiwi.model.BirdViewRepository;

import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.HealthCheckDto;
import com.nz.kiwi.view.Test;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/kiwis")
@RequiredArgsConstructor
public class KiwiController {

    @Autowired
    private final BirdServiceImpl birdService;

    @Autowired
    private final CustomBirdRepositoryImpl customBirdRepository;

    /**
     * List Bird Summary Dto (GET)
     */
    @GetMapping("/")
    public ResponseEntity<List<BirdSummaryDto>> listBirdSummaryDTO() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.listBirdSummaryDTO());
    }

    /**
     * Bird Detail Dto (GET)
     */
    @GetMapping("/{id}")
    public ResponseEntity<BirdDetailsDto> BirdDetailsDTO(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(customBirdRepository.customQuery(id));
    }

    /**
     * Create Bird (POST)
     */
    @PostMapping(value = "/", consumes = "application/json;charset=UTF-8")
    ResponseEntity<Bird> BirdCreate(@Valid @RequestBody Bird newBird) {
        System.out.println("wait");
        Bird bird = birdService.save(newBird);
        return new ResponseEntity<>(bird, HttpStatus.CREATED);
    }

    @GetMapping(value = "/custom4/{id}", produces = "application/json")
    public ResponseEntity<Object> BirdSummaryDTOCustom4(@PathVariable Long id) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Custom-Header", "foo")
                .body(customBirdRepository.customQuery4(id));
    }

}
