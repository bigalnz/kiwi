package com.nz.kiwi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ", initialValue = 100, allocationSize = 50)
@Data
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "user_seq")
    private Long id;

    private String firstname;
    private String lastname;

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
