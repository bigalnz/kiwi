package com.nz.kiwi;


import com.nz.kiwi.implementation.BirdServiceImpl;
import com.nz.kiwi.implementation.LengthMeasurementsServiceImpl;
import com.nz.kiwi.implementation.WeightMeasurementsServiceImpl;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.LengthMeasurementRepository;
import com.nz.kiwi.repository.WeightMeasurementsRepository;
import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.LengthMeasurementsDto;
import com.nz.kiwi.view.WeightMeasurementsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KiwiApplication implements CommandLineRunner {


    @Autowired
    BirdRepository birdRepository;

    @Autowired
    WeightMeasurementsServiceImpl weightMeasurementsService;

    @Autowired
    LengthMeasurementsServiceImpl lengthMeasurementsService;

    @Autowired
    BirdServiceImpl birdService;

    public static void main(String[] args) {
        SpringApplication.run(KiwiApplication.class, args);
    }

    @Override
    public void run(String... args) {


        System.out.println("Command Line Runner");
        /*		birdRepository.testQuery(1L);*/
		/*LengthMeasurementsDto lmdto = lengthMeasurementsService.getNewestLengthsByBirdId(1L);
		System.out.print(lmdto.toString());
		WeightMeasurementsDto wmdto = weightMeasurementsService.getNewestWeightsByBirdId(1L);
		System.out.println(wmdto.toString());*/
        System.out.println("Query run");
        BirdDetailsDto bdto = birdService.getBirdDetailsDtoById(1L);
        System.out.println(bdto.toString());

    }
}