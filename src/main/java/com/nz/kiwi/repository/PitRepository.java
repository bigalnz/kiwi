package com.nz.kiwi.repository;

import com.nz.kiwi.model.Pit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // DELETE
public interface PitRepository extends JpaRepository<Pit, Long> {

    Optional<Pit> findById(Long id);

}
