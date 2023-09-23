package com.nz.kiwi.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor

@Getter
@Setter
public class PitDto implements Serializable {
    private Long taskId;
    private String code;
    private LocalDate dateInserted;
    private String comment;
    private Long healthCheckId;


    public PitDto(Long taskId, String code, Long healthCheckId) {
        this.taskId = taskId;
        this.code = code;
        this.healthCheckId = healthCheckId;
    }

    public PitDto(Long taskId, String code, LocalDate dateInserted, String comment, Long healthCheckId) {
        this.taskId = taskId;
        this.code = code;
        this.dateInserted = dateInserted;
        this.comment = comment;
        this.healthCheckId = healthCheckId;
    }
}
