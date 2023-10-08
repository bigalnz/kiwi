package com.nz.kiwi.controller;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.service.BirdService;
import com.nz.kiwi.view.BirdCreateDto;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/kiwis")
@RequiredArgsConstructor
public class KiwiController {

    /**
     * TO DO
     * Make create bird return a location
     * Create a update controller
     */

    private final BirdService birdService;

    /**
     * List Bird Summary Dto (GET)
     */
    @GetMapping("/")
    public ResponseEntity<List<BirdSummaryDto>> listBirdSummaryDTO() {
        return ResponseEntity.ok()
                .body(birdService.listBirdSummaryDTO());
    }

    /**
     * Bird Detail Dto (GET)
     */
    @GetMapping("/{id}")
    public ResponseEntity<BirdDetailsDto> getBirdDetailsDTO(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(birdService.getBirdDetails(id));
    }

    /**
     * Create Bird (POST)
     */
    @PostMapping(value = "/", consumes = "application/json")
    ResponseEntity<?> createBirdDto(@Valid @RequestBody BirdCreateDto newBird) {
        System.out.println("wait");
        Bird bird = birdService.createBird(newBird);
        URI location = URI.create("/api/kiwis/" + bird.getId());
        //return new ResponseEntity<>(bird, HttpStatus.CREATED);
        return ResponseEntity.created(location).build();
    }

    /**
     * Update Bird (PUT)
     */
    @PutMapping(value = "/{id}", consumes = "application/json")
    ResponseEntity<BirdCreateDto> updateBirdDto(@Valid @RequestBody BirdCreateDto updateBird, @PathVariable Long id) {
        System.out.println("wait");
        BirdCreateDto bird = birdService.updateBird(updateBird, id);
        return new ResponseEntity<>(bird, HttpStatus.OK);
    }

}
