package com.nz.kiwi.view;

import lombok.Value;

import java.io.Serializable;

@Value
public class WeightDto implements Serializable {

    Double weight;

    public WeightDto(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

}
