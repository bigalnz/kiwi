package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdTestDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

/*    public static SessionFactory getCurrentSessionFromJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");.
        SessionFactory factory = emf.unwrap(SessionFactory.class);
        return factory;
    }

    Session hibernateSession = getCurrentSessionFromJPA().openSession();
    org.hibernate.Query query = hibernateSession.createQuery("SELECT NEW com.nz.kiwi.view.BirdDetailsDto(b.name, b.sex, b.status, lm.beakLength, lm.legLength) " +
            "FROM Bird b JOIN (SELECT l.beakLength beakLength, l.legLength legLength FROM b.healthCheck.lengthMeasurements l " +
            "ORDER BY l.healthCheck.checkDate DESC LIMIT 1) lm");*/

    @Query("SELECT b FROM Bird b JOIN FETCH b.listHealthCheck h  WHERE b.id = :id")
            Optional<Bird> getBirdwithPIT(@Param("id") Long id);

    // USING BIRD INFO INTERFACE
    List<BirdInfo> findBirdById(Long id);

    // USING BIRD INFO INTERFACE
    List<BirdInfo> findAllBy();

    // USING ONE BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.name, b.sex, b.status, b.currentTransmitter, b.currentPit) FROM Bird b WHERE b.id = :id")
    BirdSummaryDto findBirdDTO(Long id);

    // USING LIST BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.name, b.sex, b.status, b.currentTransmitter, b.currentPit) " +
            "FROM Bird b " +
            "LEFT JOIN b.currentTransmitter t " +
            "LEFT JOIN b.currentPit p")
    List<BirdSummaryDto> listBirdDTO();

    @Query("SELECT NEW com.nz.kiwi.view.BirdTestDto(b.name, b.status, b.sex, b.listHealthCheck) " +
            "FROM Bird b " +
            "INNER JOIN b.listHealthCheck h" +
            " WHERE b.id = :id")
    Optional<BirdTestDto> testBirdTestDto(@Param("id") Long id);

}
