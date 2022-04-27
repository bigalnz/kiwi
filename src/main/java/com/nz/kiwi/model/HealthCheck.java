package com.nz.kiwi.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nz.kiwi.enumeration.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bird bird;

    @Column(columnDefinition = "POINT")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    private Point location;
    private LocalDate catchDate;
    private LocalTime catchTime;
    private LocalTime releaseTime;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    private List<Weight> weights = new ArrayList<>();

    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    private List<TarsusLength> tarsusLengths = new ArrayList<>();

    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    private List<TarsusDepth> tarsusDepths;

    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    private List<TarsusWidth> tarsusWidths = new ArrayList<>();

    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCheck")
    private List<BeakLength> beakLengths = new ArrayList<>();

    private BodyLocation parasiteLocation;
    private Coverage parasiteCoverage;
    private BodyLocation liceLocation;
    private Coverage liceCoverage;
    private SkinDisorder skinDisorder;
    private Behaviour behaviour;
    private BodyCondition bodyCondition;
    private Capture capture;
    @Lob
    private String catchingComment;
    @Lob
    private String diseaseComment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthCheck )) return false;
        return id != null && id.equals(((HealthCheck) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
