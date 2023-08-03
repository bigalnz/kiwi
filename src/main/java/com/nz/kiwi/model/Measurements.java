package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Measurements extends Task {

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
