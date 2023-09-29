package com.nz.kiwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * A test class that runs the main application class with a Test Container
 * throw-away DB.
 */

@TestConfiguration(proxyBeanMethods = false)
public class KiwiApplicationTestWithDb {

    @Bean
    @ServiceConnection
    MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
                .withUsername("root")
                .withPassword("Ryangra2017")
                .withDatabaseName("kiwi");
    }

    public static void main(String[] args) {
        SpringApplication.from(KiwiApplication::main).with(KiwiApplicationTestWithDb.class).run(args);
    }
}

