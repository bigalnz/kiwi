package com.nz.kiwi.controller;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kiwis")
@RequiredArgsConstructor
public class KiwiController {

    private final BirdServiceImpl birdService;

    private final CustomBirdRepositoryImpl customBirdRepository;

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
    public ResponseEntity<BirdDetailsDto> BirdDetailsDTO(@PathVariable Long id) {
        return ResponseEntity.ok()
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
                .body(customBirdRepository.customQuery4(id));
    }

}
