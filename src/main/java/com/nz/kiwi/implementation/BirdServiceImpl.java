package com.nz.kiwi.implementation;

import com.nz.kiwi.view.BirdInfo;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.service.BirdService;
import com.nz.kiwi.view.BirdTestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BirdServiceImpl implements BirdService {

    private final BirdRepository birdRepository;

    public List<BirdInfo> findBirdById(Long id) {
        return birdRepository.findBirdById(id);
    }

    public Optional<BirdSummaryDto> findBirdDTO(Long id) {
        return birdRepository.findBirdDTO(id);
    }

    public List<BirdSummaryDto> listBirdDTO() {
        List<BirdSummaryDto> test = birdRepository.listBirdDTO();
        return birdRepository.listBirdDTO();
    }

    public List<BirdInfo> findAllBy() {
        return birdRepository.findAllBy();
    }

    public Optional<Bird> get(Long id) {
        return birdRepository.findById(id);
    }

    @Override
    public Bird saveBird(Bird bird) {
        return birdRepository.save(bird);
    }

    @Override
    public Optional<Bird> getBirdWithPIT(Long id) {
        return birdRepository.getBirdwithPIT(id);
    }

    public Optional<BirdTestDto> testBirdTestDto(Long id) {
        System.out.println("test");
        Optional<BirdTestDto> test = birdRepository.testBirdTestDto(id);
        return birdRepository.testBirdTestDto(id);
    }
}
