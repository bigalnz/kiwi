package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PIT extends Task {

    @Column(unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String code;
    @JoinColumn(name ="date_inserted")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateInserted;
    @Lob
    private String comment;

}
