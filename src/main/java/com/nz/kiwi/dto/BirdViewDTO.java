package com.nz.kiwi.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class BirdViewDTO extends BirdDTO {

    private String status;
    private String comment;

    public BirdViewDTO() {}

    public BirdViewDTO(String status, String comment) {
        this.status = status;
        this.comment = comment;
    }

    public BirdViewDTO(Long birdId, Long healthCheckId, String name, String sex, LocalDate catchDate, String code, Integer channel, String status, String comment) {
        super(birdId, healthCheckId, name, sex, catchDate, code, channel);
        this.status = status;
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
