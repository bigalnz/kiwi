package com.nz.kiwi.controller;

import com.nz.kiwi.model.PIT;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDTO;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kiwis")
@RequiredArgsConstructor
public class KiwiController {

    @Autowired
    private final BirdServiceImpl birdService;

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
    public ResponseEntity<Optional<BirdSummaryDTO>> findDTO(@PathVariable Long id) {
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
    public ResponseEntity<List<BirdSummaryDTO>> listBirdDTO() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(birdService.listBirdDTO());
    }

    // SAVE ONE PIT
    @PostMapping(value = "/", consumes = {MediaType.APPLICATION_JSON_VALUE})
    Bird newBird(@RequestBody Bird bird) {
        return birdService.saveBird(bird);
    }

/*

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
