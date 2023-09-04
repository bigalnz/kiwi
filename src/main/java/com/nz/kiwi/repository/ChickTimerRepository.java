package com.nz.kiwi.repository;

import com.nz.kiwi.model.ChickTimer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChickTimerRepository extends JpaRepository<ChickTimer, Long> {

    List<ChickTimer> findAll();

}
