package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.WeightMeasurements;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.BirdTestDto;
import com.nz.kiwi.view.WeightDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeightMeasurementsRepository extends JpaRepository<WeightMeasurements, Long> {
    @Query("SELECT NEW com.nz.kiwi.view.WeightDto (AVG(w.weight)) FROM WeightMeasurements w WHERE w.healthCheck.bird.id = :id")
    List<WeightDto> getWeightMeasurementsByBirdId(Long id);

}
