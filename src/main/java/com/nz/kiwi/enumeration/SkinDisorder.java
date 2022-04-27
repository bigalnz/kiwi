package com.nz.kiwi.enumeration;

public enum SkinDisorder {
    NONE("NONE"),
    LIGHT("LIGHT"),
    MODERATE("MODERATE"),
    THICKENED("THICKENED");
    private final String skinDisorder;

    SkinDisorder(String skinDisorder) {
        this.skinDisorder = skinDisorder;
    }

    public String getSkinDisorder() {
        return this.skinDisorder;
    }
}
