package com.nz.kiwi.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof LengthMeasurements))
            return false;

        LengthMeasurements other = (LengthMeasurements) o;

        return getTaskId() != null &&
                getTaskId().equals(other.getTaskId());
    }
}
