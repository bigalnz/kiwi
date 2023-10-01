package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdDetailsDto1;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
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
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.id, b.name, b.sex, b.status, b.currentTransmitter.channel, b.currentTransmitter.tuning, b.currentPit.code) FROM Bird b WHERE b.id = :id")
    BirdSummaryDto findBirdSummaryDTO(Long id);

    // USING LIST BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.id, b.name, b.sex, b.status, b.currentTransmitter.channel, b.currentTransmitter.tuning, b.currentPit.code) " +
            "FROM Bird b " +
            "LEFT JOIN b.currentTransmitter t " +
            "LEFT JOIN b.currentPit p")
    List<BirdSummaryDto> listBirdSummaryDTO();

    @Query("SELECT NEW com.nz.kiwi.view.BirdDetailsDto(b.id, b.name, b.sex, b.status, " +
            "NEW com.nz.kiwi.view.TransmitterDto(t.id, t.channel, t.tuning, t.transmitterTaskType, t.comment ), " +
            "NEW com.nz.kiwi.view.PitDto(p.id, p.code, p.dateInserted, p.comment, p.healthCheck.id ), " +
            "NEW com.nz.kiwi.view.HealthCheckDto(hc.id, hc.catchDateTime, hc.releaseDateTime, hc.location), " +
            "NEW com.nz.kiwi.view.LengthMeasurementsDto(MAX(y.lengthCheckDate), AVG(y.beakLength), AVG(y.tarsusLength), AVG(y.tarsusWidth), AVG(y.tarsusDepth)), " +
            "NEW com.nz.kiwi.view.WeightMeasurementsDto(MAX(x.weightCheckDate), AVG(x.weight))) FROM Bird b " +
            "LEFT JOIN(SELECT MAX(l.healthCheck.catchDateTime) AS lengthCheckDate, ROUND(AVG(l.beakLength), 2) AS beakLength, ROUND(AVG(l.tarsusLength), 2) AS tarsusLength, round(AVG(l.tarsusWidth), 2) AS tarsusWidth, round(AVG(l.tarsusDepth),2) AS tarsusDepth, l.healthCheck.bird.id as bid FROM LengthMeasurements l WHERE l.healthCheck.bird.id=:id GROUP BY l.healthCheck.catchDateTime ORDER BY l.healthCheck.catchDateTime DESC LIMIT 1 ) AS y " +
            "LEFT JOIN(SELECT MAX(w.healthCheck.catchDateTime) AS weightCheckDate, round(AVG(w.weight),2) AS weight FROM WeightMeasurements w WHERE w.healthCheck.bird.id=:id GROUP BY w.healthCheck.catchDateTime ORDER BY w.healthCheck.catchDateTime DESC LIMIT 1) AS x " +
            "LEFT JOIN b.currentTransmitter t " +
            "LEFT JOIN b.currentPit p " +
            "LEFT JOIN HealthCheck hc ON hc.bird.id=b.id " +
            "WHERE b.id=:id " +
            "GROUP BY b, hc ORDER BY hc.catchDateTime DESC LIMIT 1")
    BirdDetailsDto getBirdDetails(Long id);
}







