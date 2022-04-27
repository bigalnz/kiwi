package com.nz.kiwi.enumeration;

public enum Capture {
    EASY("EASY"),
    DEEP_BURROW_EASY("DEEP_BURROW_EASY"),
    DEEP_BURROW_HARD("DEEP_BURROW_HARD"),
    SURFACE_EASY("SURFACE_EASY"),
    SURFACE_CHASING("SURFACE_CHASING");
    private final String capture;

    Capture(String capture) {
        this.capture = capture;
    }

    public String getCapture() {
        return this.capture;
    }
}
