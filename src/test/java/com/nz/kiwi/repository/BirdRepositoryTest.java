package com.nz.kiwi.repository;

import com.nz.kiwi.SexFaker;
import com.nz.kiwi.StatusFaker;
import com.nz.kiwi.TaxaFaker;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.model.Bird;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BirdRepositoryTest {

    //@Autowired
    //private BirdRepository birdRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    Bird birdToDatabase;

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
