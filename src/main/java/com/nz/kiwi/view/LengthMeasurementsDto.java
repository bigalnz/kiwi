package com.nz.kiwi.view;

import com.nz.kiwi.model.LengthMeasurements;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link LengthMeasurements}
 */

@Value
public class LengthMeasurementsDto implements Serializable {
    HealthCheckDto healthCheck;
    Double beakLength;
    Double tarsusLength;
    Double tarsusWidth;
    Double tarsusDepth;

    public LengthMeasurementsDto(HealthCheckDto healthCheck, Double beakLength, Double tarsusLength, Double tarsusWidth, Double tarsusDepth) {
        this.healthCheck = healthCheck;
        this.beakLength = beakLength;
        this.tarsusLength = tarsusLength;
        this.tarsusWidth = tarsusWidth;
        this.tarsusDepth = tarsusDepth;
    }

    public HealthCheckDto getHealthCheck() {
        return healthCheck;
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
}