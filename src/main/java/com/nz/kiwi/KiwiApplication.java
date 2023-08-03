package com.nz.kiwi;

import org.h2.tools.Server;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class KiwiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KiwiApplication.class, args);
	}


	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("http://localhost/*");
			}
		};
	}








}
