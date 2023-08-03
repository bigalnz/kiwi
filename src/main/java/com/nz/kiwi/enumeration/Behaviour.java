package com.nz.kiwi.enumeration;

public enum Behaviour {

    POOED("POOED"),
    CALM("CALM"),
    STRUGGLED_LOTS("STRUGGLED LOTS"),
    STRUGGLED_SOME("STRUGGLED SOME"),
    BLEW_BUBBLES("BLEW BUBBLES");
    private final String behaviour;

    Behaviour (String behaviour) {
        this.behaviour = behaviour;
    }

    public String getBehaviour() {
        return this.behaviour;
    }

}
