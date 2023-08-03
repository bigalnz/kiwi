package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.Bird;

/**
 * A Projection for the {@link Bird} entity
 */
public interface BirdInfo {
    Long getId();

    String getName();

    Sex getSex();

    Status getStatus();

    TransmitterInfo getCurrentTransmitter();

    PITInfo getCurrentPIT();
}