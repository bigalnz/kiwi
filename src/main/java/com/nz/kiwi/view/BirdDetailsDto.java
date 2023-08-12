package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.ChickTimer;
import com.nz.kiwi.model.LengthMeasurements;
import com.nz.kiwi.model.WeightMeasurements;

public class BirdDetailsDto extends BirdSummaryDto {

    private LengthMeasurements currentLengthMeasurements;
    //private WeightMeasurements currentWeightMeasurements;
    //private ChickTimer currentChickTimer;


    @Override
    public String toString() {
        return "BirdDetailsDto{" +
                "currentLengthMeasurements=" + currentLengthMeasurements +
                "name=" + this.getName() +
                '}';
    }
}
