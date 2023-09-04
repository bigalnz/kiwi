package com.nz.kiwi.repository;

import com.nz.kiwi.model.LengthMeasurements;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.LengthMeasurementsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LengthMeasurementRepository extends JpaRepository<LengthMeasurements, Long> {


    @Query("SELECT NEW com.nz.kiwi.view.LengthMeasurementsDto(MAX(h.catchDateTime), AVG(l.beakLength), AVG(l.tarsusLength),  AVG(l.tarsusWidth), AVG(l.tarsusDepth)) FROM LengthMeasurements l " +
            "JOIN l.healthCheck.bird b " +
            "JOIN l.healthCheck h " +
            "WHERE b.id=:id GROUP BY b.id ORDER BY l.healthCheck.catchDateTime DESC LIMIT 1")
    LengthMeasurementsDto getNewestLengthsByBirdId(@Param("id") Long id);

    // USING LIST BIRDSUMMARY DTO
    @Query("SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.name, b.sex, b.status, b.currentTransmitter, b.currentPit) " +
            "FROM Bird b " +
            "LEFT JOIN b.currentTransmitter t " +
            "LEFT JOIN b.currentPit p")
    List<BirdSummaryDto> listBirdDTO();

}
