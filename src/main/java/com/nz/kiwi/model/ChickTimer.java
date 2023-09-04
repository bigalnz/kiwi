package com.nz.kiwi.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nz.kiwi.enumeration.BeatsPerMinute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Entity
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@SequenceGenerator(name = "chick_timer_seq", sequenceName = "CT_SEQ", initialValue = 100, allocationSize = 50)
public class ChickTimer {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "chick_timer_seq")
    private Long id;

    private Point<G2D> location;

    private LocalDateTime ctDateTime;

    @ManyToOne
    private User userRecorder;

    @ManyToOne
    @JsonManagedReference
    private Bird bird;

    private Integer beatsPerMinute;
    private Integer dChangeState;
    private Integer dHatch;
    private Integer dDesertAlert;
    private Integer wksTxLife;
    private Integer emergenceHour;
    private Integer yesterday;
    private Integer twoDaysAgo;
    private Integer meanFourDays;

}
