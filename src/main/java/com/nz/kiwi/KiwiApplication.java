package com.nz.kiwi;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.repository.BirdRepository;
import com.nz.kiwi.repository.CustomBirdRepositoryImpl;
import com.nz.kiwi.repository.HealthCheckRepository;
import com.nz.kiwi.service.ChickTimerService;
import com.nz.kiwi.view.HealthCheckDto;
import lombok.extern.slf4j.Slf4j;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Slf4j
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KiwiApplication implements CommandLineRunner {
    public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZER = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));


    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LOCAL_DATETIME_SERIALIZER);

        GeolatteGeomModule geolatteGeomModule = new GeolatteGeomModule(WGS84);
        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false)
                .registerModule(geolatteGeomModule)
                .registerModule(new JtsModule())
                .registerModule(timeModule);
        return objectMapper;
    }


    @Autowired
    ChickTimerService chickTimerService;

    @Autowired
    HealthCheckRepository healthCheckRepository;

    @Autowired
    CustomBirdRepositoryImpl customBirdRepository;

    @Autowired
    BirdRepository birdRepository;


    private static final Logger logger = LoggerFactory.getLogger(KiwiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KiwiApplication.class, args);
    }


    @Override
    public void run(String... args) {

        System.out.println("Command Line Runner");
        Point<G2D> pnt = point(WGS84, g(34.33, 53.21));
        //HealthCheck hc = healthCheckRepository.findById(5L).orElse(null);
        HealthCheckDto hc = customBirdRepository.customQuery5(5L);
        //hc.ifPresent(hc1 -> hc1.setLocation(pnt));
        hc.setLocation(pnt);
        //customBirdRepository.save(hc); <---- fix this

        HealthCheck hc1 = new HealthCheck();
        hc1.setId(10L);
        hc1.setBird(birdRepository.getById(1L));
        hc1.setLocation(pnt);
        healthCheckRepository.save(hc1);

        //long startTime2 = System.currentTimeMillis();
        //BirdDetailsDto dto = customBirdRepository.customQuery(1l);
        //System.out.println("Total time [ms]: " + (System.currentTimeMillis() - startTime2));
        chickTimerService.findAll();
        System.out.println("Command line runner");

    }
}