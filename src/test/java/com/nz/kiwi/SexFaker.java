package com.nz.kiwi;

import net.datafaker.Faker;

public class SexFaker extends Faker {
    public Sex sex() {
        return getProvider(Sex.class, Sex::new, this);
    }
}
