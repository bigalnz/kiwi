package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nz.kiwi.model.User;

@Repository
public interface UserRepository extends JpaRepository<Bird, Long> {
    User save(User user);

}
