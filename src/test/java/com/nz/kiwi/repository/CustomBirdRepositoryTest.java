package com.nz.kiwi.repository;

import com.nz.kiwi.SexFaker;
import com.nz.kiwi.StatusFaker;
import com.nz.kiwi.TaxaFaker;
import com.nz.kiwi.model.Bird;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:mysql:8.1.0:///test?TC_REUSABLE=true"
})

public class CustomBirdRepositoryTest {

    @Autowired
    private CustomBirdRepository customBirdRepository;

    Bird birdFromDatabase;

/*    @BeforeEach
    public void setUp() {
        // With DataFaker
        TaxaFaker taxaFaker = new TaxaFaker();
        SexFaker sexFaker = new SexFaker();
        StatusFaker statusFaker = new StatusFaker();
        Faker faker = new Faker();
        birdFromDatabase = new Bird();
        birdFromDatabase.setName(faker.name().firstName());
        birdFromDatabase.setTaxa(taxaFaker.taxa().nextTaxa());
        birdFromDatabase.setSex(sexFaker.sex().nextSex());
        birdFromDatabase.setStatus(statusFaker.status().nextStatus());
    }*/

    @Test
    @Sql("/data-customer.sql")
    void shouldReturnReturnBirdDetalisDto() {

    }

}
