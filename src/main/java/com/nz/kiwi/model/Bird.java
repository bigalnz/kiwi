package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

;

@Entity
@Data
@SequenceGenerator(name = "bird_seq", sequenceName = "BIRD_SEQ", initialValue = 100, allocationSize = 50)
@Table(name = "bird")
public class Bird {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "bird_seq")
    private Long id;
    @Column(unique = true)
    @NotEmpty
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

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<HealthCheck> listHealthCheck = new ArrayList<>();

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<ChickTimer> listChickTimer = new ArrayList<>();

    public Bird() {
    }

    ;

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

    public Bird(Long id, String name, Status status, LocalDate dateDeceased, Sex sex, Taxa taxa, String comment, Transmitter currentTransmitter, Pit currentPit, List<HealthCheck> listHealthCheck, List<ChickTimer> listChickTimer) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dateDeceased = dateDeceased;
        this.sex = sex;
        this.taxa = taxa;
        this.comment = comment;
        this.currentTransmitter = currentTransmitter;
        this.currentPit = currentPit;
        this.listHealthCheck = listHealthCheck;
        this.listChickTimer = listChickTimer;
    }

    public Bird(String name, Status status, Sex sex, Taxa taxa, String comment) {
        this.name = name;
        this.status = status;
        this.sex = sex;
        this.taxa = taxa;
        this.comment = comment;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDateDeceased() {
        return dateDeceased;
    }

    public void setDateDeceased(LocalDate dateDeceased) {
        this.dateDeceased = dateDeceased;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Taxa getTaxa() {
        return taxa;
    }

    public void setTaxa(Taxa taxa) {
        this.taxa = taxa;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ChickTimer> getListChickTimer() {
        return listChickTimer;
    }

    public void setListChickTimer(List<ChickTimer> listChickTimer) {
        this.listChickTimer = listChickTimer;
    }
}