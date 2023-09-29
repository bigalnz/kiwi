package com.nz.kiwi.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
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

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Pit))
            return false;

        Pit other = (Pit) o;

        return getTaskId() != null &&
                getTaskId().equals(other.getTaskId());
    }
}
