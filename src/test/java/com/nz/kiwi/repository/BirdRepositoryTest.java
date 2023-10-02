package com.nz.kiwi.repository;

import com.nz.kiwi.SexFaker;
import com.nz.kiwi.StatusFaker;
import com.nz.kiwi.TaxaFaker;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdDetailsDto;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:mysql:8.1.0:///kiwi?TC_REUSABLE=true"
})

public class BirdRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BirdRepository birdRepository;

    Bird birdToDatabase;
    BirdDetailsDto birdFromDatabase;

    @Test
    @Sql("/data-custom.sql")
    public void shouldReturnReturnBirdDetalisDto() {
        birdFromDatabase = birdRepository.getBirdDetails(1L);
        assertThat(birdFromDatabase).isNotNull();
        assertTrue(birdFromDatabase instanceof BirdDetailsDto);
        assertEquals(1, birdFromDatabase.getId());
        assertEquals("Natasha", birdFromDatabase.getName());
        assertEquals("ABC123", birdFromDatabase.currentPitDto.getCode());
        assertEquals(50, birdFromDatabase.currentTransmitterDto.getChannel());
        assertEquals(7.25, birdFromDatabase.lengthMeasurementsDto.getTarsusWidth());
        assertEquals(10.85, birdFromDatabase.lengthMeasurementsDto.getTarsusDepth());
        assertEquals(45.15, birdFromDatabase.lengthMeasurementsDto.getTarsusLength());
        assertEquals(3.08, birdFromDatabase.weightMeasurementsDto.getWeight());

    }



    @BeforeEach
    public void setUp() {
        // With DataFaker
        TaxaFaker taxaFaker = new TaxaFaker();
        SexFaker sexFaker = new SexFaker();
        StatusFaker statusFaker = new StatusFaker();
        Faker faker = new Faker();
        birdToDatabase = new Bird();
        birdToDatabase.setName(faker.name().firstName());
        birdToDatabase.setTaxa(taxaFaker.taxa().nextTaxa());
        birdToDatabase.setSex(sexFaker.sex().nextSex());
        birdToDatabase.setStatus(statusFaker.status().nextStatus());
    }


    @Test
    void shouldSaveAndReturnBird() {
        Bird result = testEntityManager.persistAndFlush(birdToDatabase);
        assertNotNull(result.getId());
    }

}
