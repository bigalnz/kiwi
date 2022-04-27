package com.nz.kiwi.enumeration;

public enum Behaviour {

    POOED("POOED"),
    CALM("CALM"),
    STRUGGLED_LOTS("STRUGGLED_LOTS"),
    STRUGGLED_SOME("STRUGGLED_SOME"),
    BLEW_BUBBLES("BLEW_BUBBLES");
    private final String behaviour;

    Behaviour (String behaviour) {
        this.behaviour = behaviour;
    }

    public String getBehaviour() {
        return this.behaviour;
    }

}
