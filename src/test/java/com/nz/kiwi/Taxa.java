package com.nz.kiwi;

import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;

public class Taxa extends AbstractProvider<BaseProviders> {

    private static final com.nz.kiwi.enumeration.Taxa[] TAXA = new com.nz.kiwi.enumeration.Taxa[]{com.nz.kiwi.enumeration.Taxa.ROWI,
            com.nz.kiwi.enumeration.Taxa.LITTE_SPOTTED,
            com.nz.kiwi.enumeration.Taxa.GREAT_SPOTTED,
            com.nz.kiwi.enumeration.Taxa.BROWN_KIWI,
            com.nz.kiwi.enumeration.Taxa.TOKOEKA};

    public Taxa(BaseProviders faker) {
        super(faker);
    }

    public com.nz.kiwi.enumeration.Taxa nextTaxa() {
        return TAXA[faker.random().nextInt(TAXA.length)];
    }
}

