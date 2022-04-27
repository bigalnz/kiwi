package com.nz.kiwi.enumeration;

public enum BeatsPerMinute {
    INCUBATING("INCUBATING"),
    NOT_INCUBATING("NOT_INCUBATING"),
    MORTAILTY("MORTILTY");
    private final String beatsPerMinute;

    BeatsPerMinute (String beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    public String getBeatsPerMinute() {
        return this.beatsPerMinute;
    }
}
