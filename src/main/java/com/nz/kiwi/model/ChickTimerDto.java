package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link ChickTimer}
 */
@AllArgsConstructor
@Getter
public class ChickTimerDto implements Serializable {
    private final Long id;
    private final Point<G2D> location;
    private final LocalDateTime ctDateTime;
    private final Integer beatsPerMinute;
    private final Integer dChangeState;
    private final Integer dHatch;
    private final Integer dDesertAlert;
    private final Integer wksTxLife;
    private final Integer emergenceHour;
    private final Integer yesterday;
    private final Integer twoDaysAgo;
    private final Integer meanFourDays;
}