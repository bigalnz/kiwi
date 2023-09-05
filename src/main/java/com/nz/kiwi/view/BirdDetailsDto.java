package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Imported;

//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Imported
public class BirdDetailsDto {

    public Long id;
    public String name;
    public Sex sex;
    public Status status;
    public Transmitter currentTransmitter;
    public Pit currentPit;
    private LengthMeasurementsDto currentLengthMeasurements;
    private WeightMeasurementsDto currentWeightMeasurements;

    public BirdDetailsDto(LengthMeasurementsDto currentLengthMeasurements, WeightMeasurementsDto currentWeightMeasurements) {
        this.currentLengthMeasurements = currentLengthMeasurements;
        this.currentWeightMeasurements = currentWeightMeasurements;
    }

    public BirdDetailsDto(Long id, String name, Sex sex, Status status, Transmitter currentTransmitter, Pit currentPit, LengthMeasurementsDto currentLengthMeasurements, WeightMeasurementsDto currentWeightMeasurements) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.status = status;
        this.currentTransmitter = currentTransmitter;
        this.currentPit = currentPit;
        this.currentLengthMeasurements = currentLengthMeasurements;
        this.currentWeightMeasurements = currentWeightMeasurements;
    }
}
