package com.nz.kiwi.controller;

//import com.nz.kiwi.model.BirdView;
//import com.nz.kiwi.model.BirdViewRepository;

import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.HealthCheckDto;
import com.nz.kiwi.view.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/custom2/{id}")
    public ResponseEntity<Test> BirdSummaryDTOCustom3(@PathVariable Long id) {
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body(customBirdRepository.customQuery3(id));
    }

    @GetMapping("/custom4/{id}")
    public ResponseEntity<Object> BirdSummaryDTOCustom4(@PathVariable Long id) {
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

}
