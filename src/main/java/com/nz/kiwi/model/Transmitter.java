package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyToOne;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transmitter {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Integer channel;
    private Double channelOffset;
    //private LocalDate dateAttached;
    //@ManyToOne(fetch = FetchType.LAZY, optional = true)
    //private Bird bird;
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    private HealthCheck healthCheck;

    @Lob
    private String comment;


}
