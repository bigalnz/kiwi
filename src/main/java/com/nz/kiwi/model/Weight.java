package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weight extends Task {

    private Double measurement;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private HealthCheck healthCheck;

}
