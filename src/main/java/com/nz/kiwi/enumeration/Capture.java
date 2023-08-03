package com.nz.kiwi.enumeration;

public enum Capture {
    EASY("EASY"),
    DEEP_BURROW_EASY("DEEP BURROW EASY"),
    DEEP_BURROW_HARD("DEEP BURROW HARD"),
    SURFACE_EASY("SURFACE EASY"),
    SURFACE_CHASING("SURFACE CHASING");
    private final String capture;

    Capture(String capture) {
        this.capture = capture;
    }

    public String getCapture() {
        return this.capture;
    }
}
