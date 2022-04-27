package com.nz.kiwi.enumeration;

public enum BodyLocation {
    MOSTLY_FACE("MOSTLY_FACE"),
    MOSTLY_WING("MOSTLY_WING"),
    ALL_OVER("ALL_OVER");
    private final String bodyLocation;

    BodyLocation (String bodyLocation) {
        this.bodyLocation = bodyLocation;
    }

    public String getBodyLocation() {
        return this.bodyLocation;
    }
}
