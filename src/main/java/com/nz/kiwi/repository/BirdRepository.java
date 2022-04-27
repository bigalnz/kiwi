package com.nz.kiwi.repository;

import com.nz.kiwi.dto.BirdDTO;
import com.nz.kiwi.dto.BirdViewDTO;
import com.nz.kiwi.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BirdRepository extends JpaRepository<Bird, Long> {

    @Query(name = "list_bird_newest_hc_pit_trans", nativeQuery = true)
    Collection<BirdDTO> getBirdListDTO();

    @Query(name = "find_bird_newest_hc_pit_trans", nativeQuery = true)
    BirdDTO getBirdDTO(@Param("id")Long id);

    @Query(name = "find_bird_extended", nativeQuery = true)
    BirdViewDTO getBirdViewDTO(@Param("id")Long id);

    @Query(name = "bird.testXML", nativeQuery = false)
    Bird getBirdTestXML();
}
