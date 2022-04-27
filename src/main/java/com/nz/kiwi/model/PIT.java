package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PIT {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String code;
    //private LocalDate dateInserted;
    //@ManyToOne(fetch = FetchType.LAZY, optional = true)
    //private Bird bird;
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    private HealthCheck healthCheck;
    @Lob
    private String comment;
}
