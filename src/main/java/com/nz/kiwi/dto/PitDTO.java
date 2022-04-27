package com.nz.kiwi.dto;
import com.nz.kiwi.model.Bird;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PitDTO {

    private Long id;
    private String code;
    private LocalDate dateInserted;
    private Bird bird;
    private String comment;
}
