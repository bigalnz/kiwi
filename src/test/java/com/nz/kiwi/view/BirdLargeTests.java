package com.nz.kiwi.view;

import com.nz.kiwi.KiwiApplication;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.model.*;
import com.nz.kiwi.repository.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = {KiwiApplication.class})
class BirdLargeTests {

    @Autowired
    BirdRepository birdRepository;

    @Autowired
    HealthCheckRepository healthCheckRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PitRepository pitRepository;

    @Autowired
    TransmitterRepository transmitterRepository;

    @Autowired
    CustomBirdRepository customBirdRepository;
    @Autowired
    private WeightMeasurementsRepository weightMeasurementsRepository;
    @Autowired
    private LengthMeasurementRepository lengthMeasurementRepository;
    @Autowired
    private MeasurementRepository measurementRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void should_check_current_pit_is_null() throws ParseException {
        /** Create a bird, user, healthcheck - then add both to bird */
        Bird bird1 = birdRepository.save(new Bird("Octavia", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "Unit test Octavia"));
        Bird bird2 = birdRepository.save(new Bird("Jared", Status.ALIVE, Sex.MALE, Taxa.BROWN_KIWI, "Unit test Jono"));
        User user1 = userRepository.save(new User("Clint", "Eastwood"));
        User user2 = userRepository.save(new User("Julia", "Roberts"));

        Point<G2D> geolatte_location = point(WGS84, g(1744.33, -53.21));

        /** add tx, pit, weights(1) and measurements (3)  to healthCheck2020*/
        HealthCheck healthCheck2020 = healthCheckRepository.save(new HealthCheck(bird1,
                LocalDateTime.of(2020, 03, 28, 14, 33),
                LocalDateTime.of(2020, 03, 28, 14, 55),
                geolatte_location,
                user1, user1)
        );

        HealthCheck healthCheck2021 = healthCheckRepository.save(new HealthCheck(bird1,
                LocalDateTime.of(2021, 03, 23, 11, 07),
                LocalDateTime.of(2021, 03, 23, 11, 22),
                geolatte_location,
                user1, user1)
        );

        HealthCheck healthCheck2022 = healthCheckRepository.save(new HealthCheck(bird1,
                LocalDateTime.of(2022, 03, 22, 12, 31),
                LocalDateTime.of(2022, 03, 22, 12, 49),
                geolatte_location,
                user1, user1)
        );

        Transmitter transmitter2020 = transmitterRepository.save(new Transmitter(70, 1.5,
                LocalDateTime.of(2020, 03, 28, 14, 33),
                LocalDateTime.of(2020, 03, 28, 14, 55),
                Transmitter.Type.REPLACED,
                "Replaced in 2021"
        ));

        Transmitter transmitter2021 = transmitterRepository.save(new Transmitter(71, 1.5,
                LocalDateTime.of(2021, 03, 28, 14, 33),
                LocalDateTime.of(2021, 03, 28, 14, 55),
                Transmitter.Type.REPLACED,
                "comment"
        ));
        Transmitter transmitter2022 = transmitterRepository.save(new Transmitter(73, 1.5,
                LocalDateTime.of(2022, 03, 28, 14, 33),
                LocalDateTime.of(2022, 03, 28, 14, 55),
                Transmitter.Type.ATTACHED,
                "comment"
        ));

        WeightMeasurements weightMeasurements2020 = weightMeasurementsRepository.save(new WeightMeasurements(3.3));
        LengthMeasurements lengthMeasurements2020_1 = lengthMeasurementRepository.save(new LengthMeasurements(99.1, 14.1, 7.0, 6.0));
        LengthMeasurements lengthMeasurements2020_2 = lengthMeasurementRepository.save(new LengthMeasurements(99.2, 14.7, 7.0, 6.0));
        LengthMeasurements lengthMeasurements2020_3 = lengthMeasurementRepository.save(new LengthMeasurements(99.3, 14.2, 7.0, 6.0));

        WeightMeasurements weightMeasurements2021 = weightMeasurementsRepository.save(new WeightMeasurements(3.3));
        LengthMeasurements lengthMeasurements2021_1 = lengthMeasurementRepository.save(new LengthMeasurements(99.1, 14.1, 7.0, 6.0));
        LengthMeasurements lengthMeasurements2021_2 = lengthMeasurementRepository.save(new LengthMeasurements(99.2, 14.7, 7.0, 6.0));
        LengthMeasurements lengthMeasurements2021_3 = lengthMeasurementRepository.save(new LengthMeasurements(99.3, 14.2, 7.0, 6.0));

        WeightMeasurements weightMeasurements2022 = weightMeasurementsRepository.save(new WeightMeasurements(3.3));
        LengthMeasurements lengthMeasurements2022_1 = lengthMeasurementRepository.save(new LengthMeasurements(99.1, 14.1, 7.0, 6.0));
        LengthMeasurements lengthMeasurements2022_2 = lengthMeasurementRepository.save(new LengthMeasurements(99.2, 14.7, 7.0, 6.0));
        LengthMeasurements lengthMeasurements2022_3 = lengthMeasurementRepository.save(new LengthMeasurements(99.3, 14.2, 7.0, 6.0));


        Pit pit2020 = pitRepository.save(new Pit("XRY87727", LocalDate.of(2020, 03, 28), "comment"));
        Pit pit2021 = pitRepository.save(new Pit("GHFD6787", LocalDate.of(2021, 03, 22), "comment"));
        Pit pit2022 = pitRepository.save(new Pit("GHFD4858", LocalDate.of(2021, 03, 22), "comment"));

        /** Setup one side of the relationship (One To Many) */
        pit2020.setHealthCheck(healthCheck2020);
        transmitter2020.setHealthCheck(healthCheck2020);
        lengthMeasurements2020_1.setHealthCheck(healthCheck2020);
        lengthMeasurements2020_2.setHealthCheck(healthCheck2020);
        lengthMeasurements2020_3.setHealthCheck(healthCheck2020);
        weightMeasurements2020.setHealthCheck(healthCheck2020);
        pitRepository.save(pit2020);
        transmitterRepository.save(transmitter2020);
        measurementRepository.save(lengthMeasurements2020_1);
        measurementRepository.save(lengthMeasurements2020_2);
        measurementRepository.save(lengthMeasurements2020_3);
        weightMeasurementsRepository.save(weightMeasurements2020);

        /** Setup other side of side of the relatioship (Many To One) i.e. create a list of Tasks to Add to HealthCheck */
        List<Task> tasks2020 = new ArrayList<Task>();
        tasks2020.add(transmitter2020);
        tasks2020.add(pit2020);
        tasks2020.add(weightMeasurements2020);
        tasks2020.add(lengthMeasurements2020_1);
        tasks2020.add(lengthMeasurements2020_2);
        tasks2020.add(lengthMeasurements2020_3);
        healthCheck2020.setTasks(tasks2020);
        healthCheckRepository.save(healthCheck2020);


        bird1.setCurrentPit(pit2020);
        bird1.setCurrentTransmitter(transmitter2020);
        bird1.addHealthCheck(healthCheck2020);
        bird1.addHealthCheck(healthCheck2021);
        bird1.addHealthCheck(healthCheck2022);

        /** Get Bird1 (probably id=100) Detailed Dto */
        assertNotNull(customBirdRepository.customQuery(bird1.getId()));

        assertNotNull(bird1.getListHealthCheck());
        //assert(bird.getListHealthCheck().size()==3);
        assertNotNull(healthCheck2020);
        assertNotNull(healthCheck2020.getLocation());
        assertEquals(healthCheck2020.getLocation().getClass(), Point.class);
    }

    @Test
    void should_bird_summary_dto() {
        Bird bird = birdRepository.save(new Bird("Natalie", Status.ALIVE, Sex.FEMALE, Taxa.BROWN_KIWI, "JPA Unit Test"));
        BirdSummaryDto birdSummaryDto = new BirdSummaryDto(bird.getId(), bird.getName(), bird.getSex(), bird.getStatus());
        assertNotNull(birdSummaryDto);
    }
}