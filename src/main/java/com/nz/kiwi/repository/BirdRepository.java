package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdTestDto;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
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
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.name, b.sex, b.status, b.currentTransmitter, b.currentPit) FROM Bird b WHERE b.id = :id")
    BirdSummaryDto findBirdSummaryDTO(Long id);

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
/*

    I want the query below to return something like:
            +---------+-----------+---------------------+------------+-----------+-----------+--------------------+------------+
            | bird.id | bird.name | recent measure date | avg length | avg width | avg depth | recent weight date | avg weight |
            +---------+-----------+---------------------+------------+-----------+-----------+--------------------+------------+
    At the moment it returns all of the most recent avg measurements but not the most recent avg weights.
    Bird has OneToMany on List<HealthCheck>
    https://github.com/bigalnz/kiwi/blob/master/src/main/java/com/nz/kiwi/model/Bird.java
    HealthCheck has OnetomANY on List<Task>
    https://github.com/bigalnz/kiwi/blob/master/src/main/java/com/nz/kiwi/model/HealthCheck.java
    Task is abstract class and could be any of LengthMeasurements, WeightMeasurements and potentially a few others.
    https://github.com/bigalnz/kiwi/blob/master/src/main/java/com/nz/kiwi/model/LengthMeasurements.java
    https://github.com/bigalnz/kiwi/blob/master/src/main/java/com/nz/kiwi/model/WeightMeasurements.java

    Also note that the most recent Lengths and Weights collections may be on seperate HealthChecks (hence getting them by most recent date seperately).
    I do not think I am doing the LEFT JOIN (SELECT....) correctly - does JPQL even allow JOIN (SELECT.... ) ?

    Do I need bi-directional relationships on my OneToMany's?

    @Query(" SELECT MAX(h.catchDateTime), AVG(l.beakLength), AVG(l.tarsusLength),  AVG(l.tarsusWidth), b.name FROM LengthMeasurements l \n" +
            " JOIN l.healthCheck.bird b \n" +
            " JOIN l.healthCheck h \n" +
            " LEFT JOIN (SELECT MAX(w.healthCheck.catchDateTIme), AVG(w.weight), w.healthCheck.bird.id as bid FROM WeightMeasurements w WHERE w.healthCheck.bird.id=1) AS x\n" +
            " ON x.bid = w.healthCheck.bird.id\n" +
            " WHERE b.id=1 ");
    BirdTestDto getfullBirdTestDto(@Param("id") Long id);
*/


}
