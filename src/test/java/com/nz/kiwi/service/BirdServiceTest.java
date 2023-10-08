package com.nz.kiwi.service;

import com.github.dockerjava.api.command.CreateConfigCmd;
import com.nz.kiwi.SexFaker;
import com.nz.kiwi.StatusFaker;
import com.nz.kiwi.TaxaFaker;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.error.DatabaseUniqueConstraintException;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.mapper.BirdMapper;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.view.BirdCreateDto;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BirdServiceTest {

    @InjectMocks // Any @Mocks get injected here - i.e. Any repos listed on the ServiceImpl class
    BirdServiceImpl mockedBirdServiceImpl;

    @Mock // What to inject
    private BirdRepository birdRepository;

    @Mock
    private BirdMapper birdMapper;

    Bird birdToSave;
    BirdCreateDto createBirdDtoToSave;
    @BeforeEach
    public void setUp() {
        // With DataFaker
        TaxaFaker taxaFaker = new TaxaFaker();
        SexFaker sexFaker = new SexFaker();
        StatusFaker statusFaker = new StatusFaker();
        Faker faker = new Faker();
        birdToSave = new Bird();
        birdToSave.setName(faker.name().firstName());
        birdToSave.setTaxa(taxaFaker.taxa().nextTaxa());
        birdToSave.setSex(sexFaker.sex().nextSex());
        birdToSave.setStatus(statusFaker.status().nextStatus());

        // With DataFaker
        TaxaFaker taxaFakerDto = new TaxaFaker();
        SexFaker sexFakerDto = new SexFaker();
        StatusFaker statusFakerDto = new StatusFaker();
        Faker fakerDto = new Faker();
        createBirdDtoToSave = new BirdCreateDto();
        createBirdDtoToSave.setName(fakerDto.name().firstName());
        createBirdDtoToSave.setTaxa(taxaFakerDto.taxa().nextTaxa());
        createBirdDtoToSave.setSex(sexFakerDto.sex().nextSex());
        createBirdDtoToSave.setStatus(statusFakerDto.status().nextStatus());
    }

    @Test
    @DisplayName("Checks a bird gets updated and verifies updated properties")
    void updateBirdShouldReturnUpdatedBird() {
        // ARRANGE
        Long id = 200L;
        BirdCreateDto updateBirdDto = new BirdCreateDto("Verity", Status.DECEASED, Sex.MALE, Taxa.ROWI, "Test this gets updated");
        Bird existingBird = new Bird(200L, "Jono", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "from db");
        BirdCreateDto updatedBird = new BirdCreateDto("Verity", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "Test this gets updated");

        // WHEN
        when(birdRepository.findById(200L)).thenReturn(Optional.of(existingBird));
        when(birdRepository.save(any(Bird.class))).then(returnsFirstArg());
        when(birdRepository.existsByName("Verity")).thenReturn(Boolean.FALSE);
        doNothing().when(birdMapper).partialUpdate(any(), any());
        //when(birdMapper.toEntity(any())).thenReturn(new Bird());
        when(birdMapper.toDto(any())).thenReturn(updatedBird);

        // ASSERT
        BirdCreateDto updatedBirdDto = mockedBirdServiceImpl.updateBird(updateBirdDto, 200L);
        assertThat(updatedBirdDto).isNotNull();
        assertThat(updatedBirdDto.getName().equals("Verity"));
        assertThat(updatedBirdDto.getStatus().equals(Status.DECEASED));
        assertThat(updatedBirdDto.getSex().equals(Sex.MALE));
        assertThat(updatedBirdDto.getTaxa().equals(Taxa.ROWI));
    }

    @Test
    @DisplayName("Create a bird")
    void createBirdShouldReturnBirdCreateDto() {
        // WHEN
        when(birdRepository.save(any(Bird.class))).then(returnsFirstArg());
        when(birdMapper.toEntity(any())).thenReturn(new Bird());
        when(birdRepository.existsByName(any())).thenReturn(Boolean.FALSE);
        // THEN
        Bird savedBirdDto = mockedBirdServiceImpl.createBird(createBirdDtoToSave);
        assertThat(savedBirdDto).isNotNull();
    }

    @Test
    @DisplayName("Checks a bird does already exist by name and throws Unique Exception")
    void createBirdShouldThrowDatabaseUniqueConstraintException() {
        // ARRANGE
        BirdCreateDto createBirdDto = new BirdCreateDto("jono", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "Test dups name");
        Bird existingBird = new Bird(200L, "Jono", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "from db");

        // WHEN
        when(birdRepository.existsByName(any())).thenReturn(Boolean.TRUE);

        // ASSERT
        DatabaseUniqueConstraintException e = assertThrows(DatabaseUniqueConstraintException.class, () -> {
            mockedBirdServiceImpl.createBird(createBirdDto);
        });
    }

    @Test
    @DisplayName("Verifies bird to be updated exists by id then tries to rename to existing name - should throw UniqueConstraintException")
    void updateBirdShouldThrowDatabaseUniqueConstraintException() {
        // ARRANGE
        Long id = 200L;
        BirdCreateDto updateBirdDto = new BirdCreateDto("Clara", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "Test dups name");
        Bird existingBird = new Bird(200L, "Jono", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "from db");

        // WHEN
        when(birdRepository.findById(200L)).thenReturn(Optional.of(existingBird));
        when(birdRepository.existsByName(any())).thenReturn(Boolean.TRUE);

        // ASSERT
        DatabaseUniqueConstraintException e = assertThrows(DatabaseUniqueConstraintException.class, () -> {
            mockedBirdServiceImpl.updateBird(updateBirdDto, 200L);
        });
    }


}
