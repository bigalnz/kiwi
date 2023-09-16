package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(name = "bird_seq", sequenceName = "BIRD_SEQ", initialValue = 100, allocationSize = 50)
@Table(name = "bird")
public class Bird {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "bird_seq")
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate dateDeceased;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private Taxa taxa;
    @Lob
    private String comment;

    @OneToOne(optional = true)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "current_transmitter_id", nullable = true)
    private Transmitter currentTransmitter;

    @OneToOne(optional = true)
    @JoinColumn(name = "current_pit_id")
    private Pit currentPit;

    @JsonManagedReference(value = "bird-healthcheck")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<HealthCheck> listHealthCheck = new ArrayList<>();

    @JsonManagedReference(value = "bird-chicktimer")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<ChickTimer> listChickTimer = new ArrayList<>();


    public Bird(String name) {
        this.name = name;
    }

    public Bird(Long id, String name, Status status, LocalDate dateDeceased, Sex sex, Taxa taxa, String comment, List<HealthCheck> listHealthCheck) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dateDeceased = dateDeceased;
        this.sex = sex;
        this.taxa = taxa;
        this.comment = comment;
        this.listHealthCheck = listHealthCheck;
    }


    public Bird(String name, Status status, Sex sex, Taxa taxa, String comment) {
        this.name = name;
        this.status = status;
        this.sex = sex;
        this.taxa = taxa;
        this.comment = comment;
    }

    public Bird(String name, Status status, Sex sex, Taxa taxa) {
        this.name = name;
        this.status = status;
        this.sex = sex;
        this.taxa = taxa;
    }
}