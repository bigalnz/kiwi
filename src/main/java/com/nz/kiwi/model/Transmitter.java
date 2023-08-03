package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("TRANSMITTER")
public class Transmitter extends Task {

    private Integer channel;
    private Double tuning;
    private LocalDateTime start;
    private LocalDateTime finish;

    @Enumerated(EnumType.STRING)
    Type transmitterTaskType;
    public enum Type {
        ATTACHED,
        REMOVED,
        REPLACED
    }

    @Lob
    private String comment;

}
