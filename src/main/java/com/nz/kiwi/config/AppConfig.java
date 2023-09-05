package com.nz.kiwi.config;

import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEntityViews("com.nz.kiwi.model")
@ComponentScan("com.nz.kiwi")
public class AppConfig {
}
