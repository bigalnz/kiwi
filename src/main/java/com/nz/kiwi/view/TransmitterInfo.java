package com.nz.kiwi.view;

import com.nz.kiwi.model.Transmitter;

/**
 * A Projection for the {@link Transmitter} entity
 */
public interface TransmitterInfo {
    //Long getTaskId();

    Integer getChannel();

    Double getTuning();
}