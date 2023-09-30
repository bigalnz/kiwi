package com.nz.kiwi.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.datasource.url=jdbc:tc:mysql:8.1.0:///test?TC_REUSABLE=true"
})
public class CustomBirdRepositoryTest2 {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomBirdRepository customBirdRepository;

    @TestConfiguration
    @Import(CustomBirdRepository.class)
    static class TestConfig {
    } // must a static class.

    //...
    @Test
    void shouldReturnReturnContosoDetalisDto() {
    }

}
