package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.Pit;
import com.nz.kiwi.model.Transmitter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Imported;
import com.nz.kiwi.view.PitDto;
import org.springframework.data.relational.core.sql.IsNull;

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
