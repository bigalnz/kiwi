package com.nz.kiwi;

import net.datafaker.Faker;

public class StatusFaker extends Faker {
    public Status status() {
        return getProvider(Status.class, Status::new, this);
    }
}
