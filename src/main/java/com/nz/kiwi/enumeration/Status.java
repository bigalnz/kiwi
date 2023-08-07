package com.nz.kiwi.enumeration;

public enum Status {
    ALIVE("ALIVE"),
    DECEASED("DECEASED");
    private final String birdStatus;

    Status(String birdStatus) {
        this.birdStatus = birdStatus;
    }

    public String getBirdStatus() {
        return this.birdStatus;
    }


}
