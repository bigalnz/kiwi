package com.nz.kiwi;

import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

public class Sex extends AbstractProvider<BaseProviders> {

    private static final com.nz.kiwi.enumeration.Sex[] SEX = new com.nz.kiwi.enumeration.Sex[]{com.nz.kiwi.enumeration.Sex.FEMALE,
            com.nz.kiwi.enumeration.Sex.MALE};

    public Sex(BaseProviders faker) {
        super(faker);
    }

    public com.nz.kiwi.enumeration.Sex nextSex() {
        return SEX[faker.random().nextInt(SEX.length)];
    }
}

