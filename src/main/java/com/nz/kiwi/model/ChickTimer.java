package com.nz.kiwi.model;

import com.nz.kiwi.enumeration.BeatsPerMinute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChickTimer {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private BeatsPerMinute beatsPerMinute;
    private Integer dChangeState;
    private Integer dHatch;
    private Integer dDesertAlert;
    private Integer wksTxLife;
    private Integer emergenceHour;
    private Integer yesterday;
    private Integer twoDaysAgo;
    private Integer meanFourDays;





}
