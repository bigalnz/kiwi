package com.nz.kiwi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
