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
        assertEquals("ABC123", birdFromDatabase.currentPit.getCode());
        assertEquals(50, birdFromDatabase.currentTransmitter.getChannel());
        assertEquals(7.25, birdFromDatabase.lengthMeasurements.getTarsusWidth());
        assertEquals(10.85, birdFromDatabase.lengthMeasurements.getTarsusDepth());
        assertEquals(45.15, birdFromDatabase.lengthMeasurements.getTarsusLength());
        assertEquals(3.08, birdFromDatabase.weightMeasurements.getWeight());
    }


    @Test
    void shouldSaveAndReturnBird() {
        // SETUP WITH FAKER
        TaxaFaker taxaFaker = new TaxaFaker();
        SexFaker sexFaker = new SexFaker();
        StatusFaker statusFaker = new StatusFaker();
        Faker faker = new Faker();
        birdToDatabase = new Bird();
        birdToDatabase.setName(faker.name().firstName());
        birdToDatabase.setTaxa(taxaFaker.taxa().nextTaxa());
        birdToDatabase.setSex(sexFaker.sex().nextSex());
        birdToDatabase.setStatus(statusFaker.status().nextStatus());
        // WHEN SAVING A BIRD
        Bird result = testEntityManager.persistAndFlush(birdToDatabase);
        // RESULT
        assertNotNull(result.getId());
        assertTrue(result instanceof Bird);
    }

}
