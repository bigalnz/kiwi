package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;

public class BirdSummaryDto {

    public String name;
    public Sex sex;
    public Status status;
    public Transmitter currentTransmitter;
    public Pit currentPit;

    public BirdSummaryDto() {

    }

    public BirdSummaryDto(String name, Sex sex, Status status, Transmitter currentTransmitter, Pit currentPit) {
        this.name = name;
        this.sex = sex;
        this.status = status;
        this.currentTransmitter = currentTransmitter;
        this.currentPit = currentPit;
    }

    public BirdSummaryDto(BirdSummaryDto birdSummaryDto) {

    }

    public Transmitter getCurrentTransmitter() {
        return currentTransmitter;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Status getStatus() {
        return status;
    }

    public Pit getCurrentPIT() {
        return currentPit;
    }

    @Override
    public String toString() {
        return "BirdSummaryDto{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                ", currentTransmitter=" + currentTransmitter +
                ", currentPit=" + currentPit +
                '}';
    }
}
