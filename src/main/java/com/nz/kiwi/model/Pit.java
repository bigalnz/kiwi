package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PIT")
public class Pit extends Task {

    @Column(unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String code;
    @JoinColumn(name ="date_inserted")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateInserted;
    @Lob
    private String comment;


}
