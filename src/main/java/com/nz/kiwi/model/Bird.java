package com.nz.kiwi.model;
;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nz.kiwi.dto.BirdDTO;
import com.nz.kiwi.dto.BirdViewDTO;
import com.nz.kiwi.enumeration.BirdStatus;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Taxa;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data

public class Bird {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String name;
    @Enumerated(EnumType.STRING)
    private BirdStatus status;
    private LocalDate dateDeceased;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private Taxa taxa;
    @Lob
    private String comment;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<HealthCheck> listHealthCheck = new ArrayList<>();

    public Bird addHealthCheck(HealthCheck healthCheck) {
        listHealthCheck.add(healthCheck);
        healthCheck.setBird(this);
        return this;
    }

    public Bird removeHealthCheck(HealthCheck healthCheck) {
        listHealthCheck.remove(healthCheck);
        healthCheck.setBird(null);
        return this;
    }
}