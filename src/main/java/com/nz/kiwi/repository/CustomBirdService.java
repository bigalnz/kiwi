package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.Test;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomBirdService {
    BirdDetailsDto customQuery(Long id);

    BirdSummaryDto customQuery1(Long id);

    BirdSummaryDto customQuery2(Long id);

    Test customQuery3(Long id);

    Object customQuery4(Long id);

    Object customQuery5(Long id);


}
