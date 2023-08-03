package com.nz.kiwi.enumeration;

public enum BodyLocation {
    MOSTLY_FACE("MOSTLY FACE"),
    MOSTLY_WING("MOSTLY WING"),
    ALL_OVER("ALL OVER");
    private final String bodyLocation;

    BodyLocation (String bodyLocation) {
        this.bodyLocation = bodyLocation;
    }

    public String getBodyLocation() {
        return this.bodyLocation;
    }
}
