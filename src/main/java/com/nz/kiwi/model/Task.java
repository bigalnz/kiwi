package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "task_seq", sequenceName = "TASK_SEQ", initialValue = 100, allocationSize = 50)
@Table(name = "TASK")
public abstract class Task {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "task_seq")
    private Long taskId;

    @JsonBackReference(value = "healthcheck-task")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private HealthCheck healthCheck;
}
