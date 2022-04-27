package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.PIT;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PITRepository extends JpaRepository<PIT, Long> {
}
