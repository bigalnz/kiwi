package com.nz.kiwi.enumeration;

public enum Taxa {
    BROWN_KIWI("BROWN KIWI"),
    GREAT_SPOTTED("GREAT SPOTTED"),
    LITTE_SPOTTED("LITTLE SPOTTED"),
    ROWI("ROWI"),
    TOKOEKA("TOKOEKA");
    private final String taxa;

    Taxa(String taxa) {
        this.taxa = taxa;
    }

    public String getTaxa() {
        return this.taxa;
    }
}
