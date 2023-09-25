package com.nz.kiwi;

import net.datafaker.Faker;

public class TaxaFaker extends Faker {
    public Taxa taxa() {
        return getProvider(Taxa.class, Taxa::new, this);
    }
}
