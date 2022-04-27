package com.nz.kiwi.dto;

import com.nz.kiwi.model.Bird;
import lombok.Data;
import java.time.LocalDate;

@Data
public class TransmitterDTO {

    private Long id;
    private Integer channel;
    private Double channelOffset;
    private LocalDate dateAttached;
    private Bird bird;
    private String comment;
}
