package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Transmitter))
            return false;

        Transmitter other = (Transmitter) o;

        return getTaskId() != null &&
                getTaskId().equals(other.getTaskId());
    }
}
