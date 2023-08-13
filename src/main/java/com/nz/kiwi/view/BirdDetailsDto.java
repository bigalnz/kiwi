package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.*;

public class BirdDetailsDto extends BirdSummaryDto {

    private LengthMeasurementsDto currentLengthMeasurements;
    private WeightMeasurementsDto currentWeightMeasurements;

    public BirdDetailsDto(LengthMeasurementsDto currentLengthMeasurements, WeightMeasurementsDto currentWeightMeasurements) {
        this.currentLengthMeasurements = currentLengthMeasurements;
        this.currentWeightMeasurements = currentWeightMeasurements;
    }

    public BirdDetailsDto(BirdSummaryDto birdSummaryDto) {
        super(birdSummaryDto);
        this.name = birdSummaryDto.getName();
        this.sex = birdSummaryDto.getSex();
        this.status = birdSummaryDto.getStatus();
        this.currentTransmitter = birdSummaryDto.getCurrentTransmitter();
        this.currentPit = birdSummaryDto.getCurrentPIT();
    }

    public BirdDetailsDto(String name, Sex sex, Status status, Transmitter currentTransmitter, Pit currentPit, LengthMeasurementsDto currentLengthMeasurements, WeightMeasurementsDto currentWeightMeasurements) {
        super(name, sex, status, currentTransmitter, currentPit);
        this.currentLengthMeasurements = currentLengthMeasurements;
        this.currentWeightMeasurements = currentWeightMeasurements;
    }

    public LengthMeasurementsDto getCurrentLengthMeasurements() {
        return currentLengthMeasurements;
    }

    public void setCurrentLengthMeasurements(LengthMeasurementsDto currentLengthMeasurements) {
        this.currentLengthMeasurements = currentLengthMeasurements;
    }

    public WeightMeasurementsDto getCurrentWeightMeasurements() {
        return currentWeightMeasurements;
    }

    public void setCurrentWeightMeasurements(WeightMeasurementsDto currentWeightMeasurements) {
        this.currentWeightMeasurements = currentWeightMeasurements;
    }

    @Override
    public String toString() {
        return "BirdDetailsDto{" +
                "currentLengthMeasurements=" + currentLengthMeasurements +
                ", currentWeightMeasurements=" + currentWeightMeasurements +
                " , name=" + this.getName() +
                " , sex=" + this.getSex() +
                " , current PIT=" + this.getCurrentPIT().getCode() +
                " , current Channel=" + this.getCurrentTransmitter().getChannel() + "(" + this.getCurrentTransmitter().getTuning() + ")" +
                '}';
    }
}
