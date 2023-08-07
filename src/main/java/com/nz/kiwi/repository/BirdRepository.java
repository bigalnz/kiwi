package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdTestDto;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.name, b.sex, b.status, b.currentTransmitter, b.currentPit) FROM Bird b WHERE b.id = :id")
    Optional<BirdSummaryDto> findBirdDTO(Long id);

    // USING LIST BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.name, b.sex, b.status, b.currentTransmitter, b.currentPit) " +
            "FROM Bird b " +
            "LEFT JOIN b.currentTransmitter t " +
            "LEFT JOIN b.currentPit p")
    List<BirdSummaryDto> listBirdDTO();

    @Query("SELECT NEW com.nz.kiwi.view.BirdTestDto(b.name, b.sex, b.status, b.listHealthCheck) " +
            "FROM Bird b " +
            "WHERE b.id = :id")
    Optional<BirdTestDto> testBirdTestDto(@Param("id") Long id);
    
}
