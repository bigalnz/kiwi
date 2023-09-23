package com.nz.kiwi.view;

import com.nz.kiwi.KiwiApplication;
import com.nz.kiwi.model.*;
import com.nz.kiwi.repository.*;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


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