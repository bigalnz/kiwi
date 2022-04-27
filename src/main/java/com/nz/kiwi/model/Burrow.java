package com.nz.kiwi.model;

import com.nz.kiwi.enumeration.BurrowDepth;
import com.nz.kiwi.enumeration.BurrowType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Burrow {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Point location;
    private String code;
    private String commonName;
    private BurrowDepth depth;
    private BurrowType burrowType;
    @Lob
    private String description;
}
