package com.nz.kiwi.model;

import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.repository.BirdRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KiwiTest {

    @Mock
    private BirdRepository birdRepository;

    @InjectMocks
    private BirdServiceImpl birdService;

    @Test
    void testBirdServiceSave() {
        Bird bird = new Bird();
        bird.setName("Mark");
        bird.setId(90L);
        when(birdRepository.save(any(Bird.class))).then(returnsFirstArg());
        Bird birdSaved = birdService.save((bird));
        assertThat(birdSaved.getName()).isNotNull();
    }

    @Test
    void testBirdConstructor() {
        Bird bird = new Bird("Mary");
        assertEquals("Mary", bird.getName());
    }
}
