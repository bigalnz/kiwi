package com.nz.kiwi.service;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdCreateDto;
import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;

import java.util.List;
import java.util.Optional;

public interface BirdService {

    Bird save(Bird bird);

    BirdCreateDto getBirdById(Long id);

    BirdCreateDto createBird(BirdCreateDto createBirdDto);

    List<BirdInfo> findBirdById(Long id);

    List<BirdInfo> findAllBy();

    Optional<Bird> getBirdWithPIT(Long id);

    //Optional<BirdTestDto> findBirdDetailsDto(Long id);

    BirdSummaryDto findBirdSummaryDTO(Long id);

    List<BirdSummaryDto> listBirdSummaryDTO();

}
