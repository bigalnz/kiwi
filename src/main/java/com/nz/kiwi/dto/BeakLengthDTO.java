package com.nz.kiwi.dto;

import com.nz.kiwi.model.Bird;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BeakLengthDTO {
    private Long id;
    private Double measurement;
}
