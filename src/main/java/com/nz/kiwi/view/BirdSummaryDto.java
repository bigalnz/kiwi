package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;

public class BirdSummaryDto {

    public Long id;
    public String name;
    public Sex sex;
    public Status status;
    public Integer currentTransmitterChannel;
    public Double currentTransmitterTuning;
    public String currentPitCode;

    public BirdSummaryDto() {

    }

    public BirdSummaryDto(Long id, String name, Sex sex, Status status, Integer currentTransmitterChannel, Double currentTransmitterTuning, String currentPitCode) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.status = status;
        this.currentTransmitterChannel = currentTransmitterChannel;
        this.currentTransmitterTuning = currentTransmitterTuning;
        this.currentPitCode = currentPitCode;
    }

    public BirdSummaryDto(Long id, String name, Sex sex, Status status) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.status = status;
    }

    public BirdSummaryDto(BirdSummaryDto birdSummaryDto) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCurrentTransmitterChannel() {
        return currentTransmitterChannel;
    }

    public void setCurrentTransmitterChannel(Integer currentTransmitterChannel) {
        this.currentTransmitterChannel = currentTransmitterChannel;
    }

    public Double getCurrentTransmitterTuning() {
        return currentTransmitterTuning;
    }

    public void setCurrentTransmitterTuning(Double currentTransmitterTuning) {
        this.currentTransmitterTuning = currentTransmitterTuning;
    }

    public String getCurrentPitCode() {
        return currentPitCode;
    }

    public void setCurrentPitCode(String currentPitCode) {
        this.currentPitCode = currentPitCode;
    }
}
