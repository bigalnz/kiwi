package com.nz.kiwi.enumeration;

public enum BirdStatus {
    ALIVE("AVLIE"),
    DECEASED("DECEASED");
    private final String birdStatus;

    BirdStatus (String birdStatus) {
        this.birdStatus = birdStatus;
    }

    public String getBirdStatus() {
        return this.birdStatus;
    }


}
