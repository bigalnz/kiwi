package com.nz.kiwi.view;

import com.nz.kiwi.model.HealthCheckDto;
import com.nz.kiwi.model.Transmitter;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link Transmitter}
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransmitterDto implements Serializable {

    private Long taskId;
    private Integer channel;
    private Double tuning;
    private Transmitter.Type transmitterTypeTask;
    private String comment;


}