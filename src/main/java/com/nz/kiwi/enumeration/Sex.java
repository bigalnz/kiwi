package com.nz.kiwi.enumeration;

public enum Sex {
    FEMALE("FEMALE"),
    MALE("MALE");
    private final String sex;

    Sex (String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }
}
