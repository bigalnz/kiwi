package com.nz.kiwi.controller;

//import com.nz.kiwi.model.BirdView;
//import com.nz.kiwi.model.BirdViewRepository;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.view.*;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import lombok.RequiredArgsConstructor;
import org.geolatte.geom.G2D;
import org.geolatte.geom.crs.CoordinateReferenceSystem;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<HealthCheckDto> BirdSummaryDTOCustom5(@PathVariable Long id) {
        HealthCheckDto hcDto = customBirdRepository.customQuery5(id);
        System.out.println("wait");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Custom-Header", "birdApp")
                .body(customBirdRepository.customQuery5(id));
    }

/*
    // GET ONE BIRD WITH EXTENDED FIELDS
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Bird>> find(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.get(id));
    }

    // GET ONE BIRD WITH BASIC FIELDS USING INTERFACE
    @GetMapping("/projection/{id}")
    public ResponseEntity<List<BirdInfo>> findInfo(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.findBirdById(id));
    }

    // GET ONE BIRD WITH BASIC FIELDS USING DTO PROJECTION
    @GetMapping("/dto/{id}")
    public ResponseEntity<Optional<BirdSummaryDto>> findDTO(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.findBirdDTO(id));
    }

// GET A LIST OF BASIC BIRDS USING BIRDINFO INTERFACE
    @GetMapping("/")
    public ResponseEntity<List<BirdInfo>> listBirdInfo() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.findAllBy());
    }

    // GET A LIST OF BASIC BIRDS USING BIRDDTO
    @GetMapping("/dto")
    public ResponseEntity<List<BirdSummaryDto>> listBirdDTO() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.listBirdDTO());
    }

    // SAVE ONE PIT
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    Bird newBird(@RequestBody Bird bird) {
        return birdService.saveBird(bird);
    }

    // GET ONE BIRD WITH EXTENDED FIELDS
    @GetMapping("/detail/{id}")
    public ResponseEntity<BirdView> getKiwi(@PathVariable("id") Long id) {;
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdViewRepository.findById(id));
    }



    // GET LIST OF BIRDS WITH SUMMARY FIELDS
    @GetMapping("/")
    public ResponseEntity<Collection<BirdDTO>> getListBirdDTO() { // was reutninging <BirdDashboardDTO>
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.getBirdListDTO());
    }

    // GET ONE BIRD WITH EXTENDED FIELDS
    @GetMapping("/{id}")
    public ResponseEntity<BirdDTO> getKiwi(@PathVariable("id") Long id) {
        birdService.getBirdDTO(id);
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.getBirdDTO(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteKiwi(@PathVariable("id") Long id) {
        birdService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
*/

}
