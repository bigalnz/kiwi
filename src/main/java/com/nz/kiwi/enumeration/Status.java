package com.nz.kiwi.enumeration;

public enum Status {
    ALIVE("AVLIE"),
    DECEASED("DECEASED");
    private final String birdStatus;

    Status(String birdStatus) {
        this.birdStatus = birdStatus;
    }

    public String getBirdStatus() {
        return this.birdStatus;
    }


}
