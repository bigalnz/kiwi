package com.nz.kiwi.model;

import com.nz.kiwi.KiwiApplication;
import com.nz.kiwi.implementation.BirdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {KiwiApplication.class})
public class KiwiTest {

    @Autowired
    BirdServiceImpl birdService;


}
