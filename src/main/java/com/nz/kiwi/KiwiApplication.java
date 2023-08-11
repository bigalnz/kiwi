package com.nz.kiwi;

import com.blazebit.persistence.spring.data.repository.config.EnableBlazeRepositories;
import com.nz.kiwi.model.BirdViewRepository;
import com.nz.kiwi.model.WeightMeasurements;
import com.nz.kiwi.repository.WeightMeasurementsRepository;
import com.nz.kiwi.view.WeightDto;
import org.h2.tools.Server;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;
import java.util.List;

//@EntityScan("com.nz.kiwi")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
//@EnableBlazeRepositories
public class KiwiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KiwiApplication.class, args);
	}


	@Autowired
	WeightMeasurementsRepository weightMeasurementsRepository;
@Override
	public void run(String... args) {

			System.out.println("Command Line Runner");
			List<WeightDto> wl = weightMeasurementsRepository.getWeightMeasurementsByBirdId(1L);
			for (WeightDto weight : wl) {
				System.out.println("weight= " + weight.getWeight());
	}
		}

}
