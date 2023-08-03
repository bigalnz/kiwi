package com.nz.kiwi.service;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDTO;
import com.nz.kiwi.model.Bird;

import java.util.List;
import java.util.Optional;

public interface BirdService {

    //Optional<Bird> get(Long id);
    Bird saveBird(Bird bird);

    List<BirdInfo> findBirdById(Long id);

    List<BirdInfo> findAllBy();

    Optional<Bird> getBirdWithPIT(Long id);

    Optional<BirdSummaryDTO> findBirdDTO(Long id);

    List<BirdSummaryDTO> listBirdDTO();
}
