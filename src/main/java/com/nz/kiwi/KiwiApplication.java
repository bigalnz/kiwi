package com.nz.kiwi;

import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableEntityViews("com.nz.kiwi.model")
public class KiwiApplication {
    private static final Logger logger = LoggerFactory.getLogger(KiwiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KiwiApplication.class, args);
    }

}