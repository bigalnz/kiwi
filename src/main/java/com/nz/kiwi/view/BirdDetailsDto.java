package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Imported;

@AllArgsConstructor
@NoArgsConstructor
@Imported
@Data
public class BirdDetailsDto {

    public Long id;
    public String name;
    public Sex sex;
    public Status status;
    public TransmitterDto currentTransmitter;
    public PitDto currentPit;
    public HealthCheckDto healthCheck;
    public LengthMeasurementsDto lengthMeasurements;
    public WeightMeasurementsDto weightMeasurements;

}
