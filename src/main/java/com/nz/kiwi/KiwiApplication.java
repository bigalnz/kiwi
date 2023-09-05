package com.nz.kiwi;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nz.kiwi.model.*;
import com.nz.kiwi.repository.*;
import com.nz.kiwi.service.ChickTimerService;

import com.nz.kiwi.view.HealthCheckDto;
import lombok.extern.slf4j.Slf4j;
import org.geolatte.geom.C2D;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystem;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.geolatte.geom.json.GeometryDeserializer;
import org.geolatte.geom.json.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KiwiApplication {

    private static final Logger logger = LoggerFactory.getLogger(KiwiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KiwiApplication.class, args);
    }

}