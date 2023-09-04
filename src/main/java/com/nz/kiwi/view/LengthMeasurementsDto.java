package com.nz.kiwi.view;

import com.nz.kiwi.model.LengthMeasurements;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link LengthMeasurements}
 */

@Value
public class LengthMeasurementsDto implements Serializable {
    LocalDateTime lengthCheckDate;
    Double beakLength;
    Double tarsusLength;
    Double tarsusWidth;
    Double tarsusDepth;

    public LengthMeasurementsDto(LocalDateTime lengthCheckDate, Double beakLength, Double tarsusLength, Double tarsusWidth, Double tarsusDepth) {
        this.lengthCheckDate = lengthCheckDate;
        this.beakLength = beakLength;
        this.tarsusLength = tarsusLength;
        this.tarsusWidth = tarsusWidth;
        this.tarsusDepth = tarsusDepth;
    }

    public LocalDateTime getCheckDate() {
        return lengthCheckDate;
    }

    public Double getBeakLength() {
        return beakLength;
    }

    public Double getTarsusLength() {
        return tarsusLength;
    }

    public Double getTarsusWidth() {
        return tarsusWidth;
    }

    public Double getTarsusDepth() {
        return tarsusDepth;
    }

    @Override
    public String toString() {
        return "LengthMeasurementsDto{" +
                "checkDate=" + lengthCheckDate +
                ", beakLength=" + beakLength +
                ", tarsusLength=" + tarsusLength +
                ", tarsusWidth=" + tarsusWidth +
                ", tarsusDepth=" + tarsusDepth +
                '}';
    }
}