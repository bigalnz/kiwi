package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="TASK")
public abstract class Task {

    @Id
    private Long taskId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private HealthCheck healthCheck;

}
