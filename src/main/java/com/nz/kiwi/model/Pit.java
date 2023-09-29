package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PIT")
public class Pit extends Task {

    @Column(unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String code;
    @JoinColumn(name = "date_inserted")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateInserted;
    @Lob
    private String comment;

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Pit))
            return false;

        Pit other = (Pit) o;

        return getTaskId() != null &&
                getTaskId().equals(other.getTaskId());
    }
}
