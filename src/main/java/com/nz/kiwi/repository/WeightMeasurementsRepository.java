package com.nz.kiwi.repository;

import com.nz.kiwi.model.WeightMeasurements;
import com.nz.kiwi.view.WeightMeasurementsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightMeasurementsRepository extends JpaRepository<WeightMeasurements, Long> {
    @Query("SELECT NEW com.nz.kiwi.view.WeightMeasurementsDto(MAX(h.catchDateTime), AVG(w.weight)) FROM WeightMeasurements w " +
            "JOIN w.healthCheck.bird b " +
            "JOIN w.healthCheck h " +
            "WHERE b.id=:id GROUP BY b.id, h.catchDateTime ORDER BY w.healthCheck.catchDateTime DESC LIMIT 1")
    WeightMeasurementsDto getNewestWeightsByBirdId(Long id);

}
