package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Bird, Long> {
    Person save(Person person);

}
