package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitalizer", "handler"})
@SequenceGenerator(name = "health_check_seq", sequenceName = "HEALTH_CHECK_SEQ", initialValue = 100, allocationSize = 50)
@Table(name = "health_check")
public class HealthCheck {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "health_check_seq")
    private Long id;

    @JsonBackReference(value = "bird-healthcheck")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "bird_id")
    private Bird bird;

    @JsonManagedReference(value = "healthcheck-task")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    private List<Task> tasks;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime catchDateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime releaseDateTime;

    @JsonBackReference
    private Point<G2D> location;

    @ManyToOne
    @JoinColumn(name = "holder_id")
    private Person holder;
    @ManyToOne
    @JoinColumn(name = "measurer_id")
    private Person measurer;

    public HealthCheck(Bird bird, LocalDateTime catchDateTime, LocalDateTime releaseDateTime, Person holder, Person measurer) {
        this.bird = bird;
        this.catchDateTime = catchDateTime;
        this.releaseDateTime = releaseDateTime;
        this.holder = holder;
        this.measurer = measurer;
    }

    public HealthCheck(Bird bird, LocalDateTime catchDateTime, LocalDateTime releaseDateTime, Point location, Person holder, Person measurer) {
        this.bird = bird;
        this.catchDateTime = catchDateTime;
        this.releaseDateTime = releaseDateTime;
        this.location = location;
        this.holder = holder;
        this.measurer = measurer;
    }

    public HealthCheck(Long id, Bird bird, LocalDateTime catchDateTime, LocalDateTime releaseDateTime, Point location, Person holder, Person measurer) {
        this.id = id;
        this.bird = bird;
        this.catchDateTime = catchDateTime;
        this.releaseDateTime = releaseDateTime;
        this.location = location;
        this.holder = holder;
        this.measurer = measurer;
    }

}
