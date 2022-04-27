package com.nz.kiwi.enumeration;

public enum BurrowType {
    TREE("TREE"),
    SOIL("SOIL"),
    SURFACE("SURFACE");
    private final String burrowType;

    BurrowType(String burrowDepth) {
        this.burrowType = burrowDepth;
    }

    public String getBurrowType() {
        return this.burrowType;
    }
}
