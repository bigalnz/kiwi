package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitalizer", "handler"})
@SequenceGenerator(name = "test_seq", sequenceName = "TEST_SEQ", initialValue = 100, allocationSize = 50)
@Table(name = "test")
public class Test {

    @Id
    private Long id;
    private String name;

}
