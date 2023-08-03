package com.nz.kiwi.enumeration;

public enum BodyCondition {
    DYING("DYING"),
    SKINNY_BONY("SKINNY BONY"),
    MUSCLE_FAT("MUSCLE FAT"),
    OBESE("OBESE");
    private final String bodyCondition;

    BodyCondition (String bodyCondition) {
        this.bodyCondition = bodyCondition;
    }

    public String getBodyCondition() {
        return this.bodyCondition;
    }
}
