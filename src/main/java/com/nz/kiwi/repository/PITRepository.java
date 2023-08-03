package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.PIT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository // DELETE
public interface PITRepository extends JpaRepository<PIT, Long> {

    Optional<PIT> findById(Long id);

}
