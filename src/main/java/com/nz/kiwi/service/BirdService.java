package com.nz.kiwi.service;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdTestDto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BirdService {


    /*    Optional<BirdTestDto> testQuery(Long id);
        //Optional<Bird> get(Long id);*/
    Bird saveBird(Bird bird);

    List<BirdInfo> findBirdById(Long id);

    List<BirdInfo> findAllBy();

    Optional<Bird> getBirdWithPIT(Long id);

    //Optional<BirdTestDto> findBirdDetailsDto(Long id);

    Optional<BirdSummaryDto> findBirdDTO(Long id);

    List<BirdSummaryDto> listBirdDTO();

    Optional<BirdTestDto> testBirdTestDto(Long id);
}
