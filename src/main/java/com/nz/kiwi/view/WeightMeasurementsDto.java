package com.nz.kiwi.view;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
public class WeightMeasurementsDto implements Serializable {

    LocalDateTime weightCheckDate;
    Double weight;

    public WeightMeasurementsDto(LocalDateTime weightCheckDate, Double weight) {
        this.weightCheckDate = weightCheckDate;
        this.weight = weight;
    }

    public LocalDateTime getWeightCheckDate() {
        return weightCheckDate;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "WeightDto{" +
                "checkDate=" + weightCheckDate +
                ", weight=" + weight +
                '}';
    }
}
