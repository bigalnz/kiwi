package com.nz.kiwi.controller;

import com.nz.kiwi.implementation.HealthCheckServiceImpl;
import com.nz.kiwi.model.HealthCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/healthchecks")
@RequiredArgsConstructor
public class HealthCheckController {

    @Autowired
    private final HealthCheckServiceImpl healthCheckService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<HealthCheck>> find(@PathVariable Long id) {
        Optional<HealthCheck> test = healthCheckService.getOneManually(Long.valueOf(1));
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(healthCheckService.getOneManually(id));
    }

    @GetMapping("/fhc/{id}")
    public ResponseEntity<Optional<HealthCheck>> findFull(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(healthCheckService.getFullHealthCheck(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<HealthCheck>> list() {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(healthCheckService.findAllHealthChecksBy());
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
