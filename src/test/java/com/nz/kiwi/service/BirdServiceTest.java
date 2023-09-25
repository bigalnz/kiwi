package com.nz.kiwi.service;

import com.nz.kiwi.SexFaker;
import com.nz.kiwi.StatusFaker;
import com.nz.kiwi.TaxaFaker;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.repository.BirdRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BirdServiceTest {

    @InjectMocks // Any @Mocks get injected here - i.e. Any repos listed on the ServiceImpl class
    BirdServiceImpl mockedBirdService;
    Bird birdToSave;
    @Mock // What to inject
    private BirdRepository birdRepository;

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
    }

    @Test
    void shouldReturnNewBird() {
        // When
        when(birdRepository.save(any())).thenReturn(birdToSave);
        mockedBirdService.save(birdToSave);
        // Then
        verify(birdRepository).save(birdToSave);
    }
}
