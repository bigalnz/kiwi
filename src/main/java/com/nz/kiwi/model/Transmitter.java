package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("TRANSMITTER")
public class Transmitter extends Task {

    private Integer channel;
    private Double tuning;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime start;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
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
