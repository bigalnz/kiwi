package com.nz.kiwi.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class LengthMeasurements extends Task {

    private Double beakLength;
    private Double tarsusLength;
    private Double tarsusWidth;
    private Double tarsusDepth;

    public Double getBeakLength() {
        return beakLength;
    }

    public void setBeakLength(Double beakLength) {
        this.beakLength = beakLength;
    }

    public Double getTarsusLength() {
        return tarsusLength;
    }

    public void setTarsusLength(Double tarsusLength) {
        this.tarsusLength = tarsusLength;
    }

    public Double getTarsusWidth() {
        return tarsusWidth;
    }

    public void setTarsusWidth(Double tarsusWidth) {
        this.tarsusWidth = tarsusWidth;
    }

    public Double getTarsusDepth() {
        return tarsusDepth;
    }

    public void setTarsusDepth(Double tarsusDepth) {
        this.tarsusDepth = tarsusDepth;
    }
}
