package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Imported;
import com.nz.kiwi.view.PitDto;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Imported
@Data
public class Test implements Serializable {

    public Long id;
    public String name;
    public Sex sex;
    public Status status;
    public TransmitterDto currentTransmitterDto;
    public PitDto currentPitDto;
    public HealthCheckDto healthCheckDto;


}
