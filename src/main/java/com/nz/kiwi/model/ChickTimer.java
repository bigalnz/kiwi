package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name = "chick_timer")
@SequenceGenerator(name = "chick_timer_seq", sequenceName = "CT_SEQ", initialValue = 100, allocationSize = 50)
public class ChickTimer {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "chick_timer_seq")
    private Long id;

    private Point<G2D> location;

    private LocalDateTime ctDateTime;

    @ManyToOne
    private Person personRecorder;

    @ManyToOne
    @JsonBackReference(value = "bird-chicktimer")
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
