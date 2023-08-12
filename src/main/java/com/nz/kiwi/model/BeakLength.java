package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeakLength {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Double measurement;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private HealthCheck healthCheck;

}
