package com.nz.kiwi.controller;

import com.nz.kiwi.implementation.MeasurementsServiceImpl;
import com.nz.kiwi.model.LengthMeasurements;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/measure")
@RequiredArgsConstructor
public class MeasurementsController {

    @Autowired
    private final MeasurementsServiceImpl measurementsService;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<LengthMeasurements>> findMeasure(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(measurementsService.getMeasurements(id));
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
