package com.nz.kiwi.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LengthMeasurements extends Task {

    private Double beakLength;
    private Double tarsusLength;
    private Double tarsusWidth;
    private Double tarsusDepth;

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
