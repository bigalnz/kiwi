package com.nz.kiwi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.view.*;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@RestController
@RequestMapping("/kiwis")
@RequiredArgsConstructor
public class KiwiController {

    @Autowired
    private final BirdServiceImpl birdService;

    @Autowired
    private final CustomBirdRepositoryImpl customBirdRepository;

    @GetMapping("/")
    public ResponseEntity<List<BirdSummaryDto>> listBirdSummaryDTO() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.listBirdSummaryDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BirdDetailsDto> BirdDetailsDTO(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(customBirdRepository.customQuery(id));
    }

    @GetMapping("/custom3/{id}")
    public ResponseEntity<Test> BirdSummaryDTOCustom3(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(customBirdRepository.customQuery3(id));
    }

    @GetMapping("/custom4/{id}")
    public ResponseEntity<Object> BirdSummaryDTOCustom4(@PathVariable Long id) {
        Object testObject = customBirdRepository.customQuery4(id);
        System.out.println("wait");
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(customBirdRepository.customQuery4(id));
    }

    @GetMapping(value = "/custom5/{id}", produces = "application/json")
    public ResponseEntity<?> BirdSummaryDTOCustom5(@PathVariable Long id) throws JsonProcessingException {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Custom-Header", "birdApp")
                .body(new Test(id, point(WGS84, g(4.33, 53.21))));
    }

}
