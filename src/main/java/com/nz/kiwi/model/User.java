package com.nz.kiwi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

}
