package com.nz.kiwi.view;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
public class WeightMeasurementsDto implements Serializable {

    LocalDateTime checkDate;
    Double weight;

    public WeightMeasurementsDto(LocalDateTime checkDate, Double weight) {
        this.checkDate = checkDate;
        this.weight = weight;
    }

    public LocalDateTime getCheckDate() {
        return checkDate;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "WeightDto{" +
                "checkDate=" + checkDate +
                ", weight=" + weight +
                '}';
    }
}
