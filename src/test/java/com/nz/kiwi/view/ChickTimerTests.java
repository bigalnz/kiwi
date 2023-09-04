package com.nz.kiwi.view;

import com.nz.kiwi.KiwiApplication;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.enumeration.Taxa;
import com.nz.kiwi.implementation.ChickTimerServiceImpl;
import com.nz.kiwi.model.*;
import com.nz.kiwi.repository.*;
import com.nz.kiwi.service.ChickTimerService;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

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
class ChickTimerTests {

    @Autowired
    ChickTimerRepository chickTimerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Sql("create_chicktimer.sql")
    void check_chick_timer_inserts() throws ParseException {
        List<ChickTimer> listChickTImer = chickTimerRepository.findAll();
        System.out.println("wait");
    }

}