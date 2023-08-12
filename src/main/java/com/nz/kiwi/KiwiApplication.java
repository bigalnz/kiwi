package com.nz.kiwi;


import com.nz.kiwi.repository.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KiwiApplication implements CommandLineRunner {


	@Autowired
	BirdRepository birdRepository;

	public static void main(String[] args) {
		SpringApplication.run(KiwiApplication.class, args);
	}

	@Override
	public void run(String... args) {


		System.out.println("Command Line Runner");
		/*		birdRepository.testQuery(1L);*/
		System.out.println("Query run");
	}
}