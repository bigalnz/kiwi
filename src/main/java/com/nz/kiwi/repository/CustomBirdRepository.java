package com.nz.kiwi.repository;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.HealthCheckDto;
import com.nz.kiwi.view.Test;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomBirdRepository {
    BirdDetailsDto customQuery(Long id);

    BirdSummaryDto customQuery1(Long id);

    BirdSummaryDto customQuery2(Long id);

    Test customQuery3(Long id);

    Object customQuery4(Long id);

    HealthCheckDto customQuery5(Long id);


}
