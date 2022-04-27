package com.nz.kiwi.dto;

import com.nz.kiwi.model.Bird;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HealthCheckListDTO {
    private Long id;
    private LocalDate catchDate;
    private String catchingComment;
    private String name;

}
