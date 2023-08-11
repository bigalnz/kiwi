package com.nz.kiwi.model;
;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name="bird")
public class Bird {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
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

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<HealthCheck> listHealthCheck = new ArrayList<>();

    public Bird(){};

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


}