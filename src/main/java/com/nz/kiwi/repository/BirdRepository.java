package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDTO;
import com.nz.kiwi.model.Bird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    @Query("SELECT b FROM Bird b JOIN FETCH b.listHealthCheck h  WHERE b.id = :id")
            Optional<Bird> getBirdwithPIT(@Param("id") Long id);

    // USING BIRD INFO INTERFACE
    List<BirdInfo> findBirdById(Long id);

    // USING BIRD INFO INTERFACE
    List<BirdInfo> findAllBy();

    // USING ONE BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDTO(b.name, b.sex, b.status, b.currentTransmitter, b.currentPIT) FROM Bird b WHERE b.id = :id")
    Optional<BirdSummaryDTO> findBirdDTO(Long id);

    // USING LIST BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDTO(b.name, b.sex, b.status, b.currentTransmitter, b.currentPIT) FROM Bird b LEFT JOIN b.currentTransmitter t LEFT JOIN b.currentPIT p")
    List<BirdSummaryDTO> listBirdDTO();
}
