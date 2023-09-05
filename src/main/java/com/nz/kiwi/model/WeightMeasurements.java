package com.nz.kiwi.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightMeasurements extends Task {

    private Double weight;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //private HealthCheck healthCheck;

    @Override
    public String toString() {
        return "WeightMeasurements{" +
                "weight=" + weight +
                //", healthCheck=" + healthCheck +
                '}';
    }
}
