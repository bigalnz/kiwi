package com.nz.kiwi.enumeration;

public enum BurrowDepth {
    DEEP("DEEP"),
    SHALLOW("SHALLOW");
    private final String burrowDepth;

    BurrowDepth (String burrowDepth) {
        this.burrowDepth = burrowDepth;
    }

    public String getBurrowDepth() {
        return this.burrowDepth;
    }
}
