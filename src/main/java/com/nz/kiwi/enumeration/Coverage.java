package com.nz.kiwi.enumeration;

public enum Coverage {
    FEW("FEW"),
    SOME("SOME"),
    TONNES("TONNES");
    private final String coverage;

    Coverage (String coverage) {
        this.coverage = coverage;
    }

    public String getCoverage() {
        return this.coverage;
    }

}
