package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.PIT;
import com.nz.kiwi.model.Transmitter;

public class BirdSummaryDTO {

    private String name;
    private Sex sex;
    private Status status;
    private Transmitter currentTransmitter;
    private PIT currentPIT;

    public BirdSummaryDTO() {

    }

    public BirdSummaryDTO(String name, Sex sex, Status status, Transmitter currentTransmitter, PIT currentPIT) {
        this.name = name;
        this.sex = sex;
        this.status = status;
        this.currentTransmitter = currentTransmitter;
        this.currentPIT = currentPIT;
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

    public PIT getCurrentPIT() {
        return currentPIT;
    }
}
