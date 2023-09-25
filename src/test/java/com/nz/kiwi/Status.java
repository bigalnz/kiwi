package com.nz.kiwi;

import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

public class Status extends AbstractProvider<BaseProviders> {

    private static final com.nz.kiwi.enumeration.Status[] STATUS = new com.nz.kiwi.enumeration.Status[]{com.nz.kiwi.enumeration.Status.ALIVE,
            com.nz.kiwi.enumeration.Status.DECEASED};

    public Status(BaseProviders faker) {
        super(faker);
    }

    public com.nz.kiwi.enumeration.Status nextStatus() {
        return STATUS[faker.random().nextInt(STATUS.length)];
    }
}

