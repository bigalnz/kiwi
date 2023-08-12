package com.nz.kiwi;

import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.repository.WeightMeasurementsRepository;
import com.nz.kiwi.view.WeightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class KiwiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(KiwiApplication.class, args);
	}


	@Autowired
	BirdServiceImpl birdService;
@Override
	public void run(String... args) {

	System.out.println("Command Line Runner");
	birdService.getBirdDetailsDto(1L);
	System.out.println("Stop here");
}

}
