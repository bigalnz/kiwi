package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="HEALTH_CHECK")
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Bird bird;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="healthCheck")
    private List<Task> tasks;

    private LocalDateTime catchDateTime;
    private LocalDateTime releaseDateTime;
    private Point location;

    // Not needed - masurements are a type of task
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    //private List<Measurements> measurements;

    @OneToOne
    @JoinColumn(name = "holder_id")
    private User holder;
    @OneToOne
    @JoinColumn(name = "measurer_id")
    private User measurer;

}
