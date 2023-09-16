package com.nz.kiwi.model;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;

import java.time.LocalDateTime;
import java.util.List;

@EntityView(Bird.class)
public interface BirdView {

    //test
    @IdMapping
    Long getId();

    String getName();

    Status getStatus();

    Sex getSex();

    List<HealthCheckView> getListHealthCheck();

    @EntityView(HealthCheck.class)
    interface HealthCheckView {
        @IdMapping
        Long getId();

        LocalDateTime getCatchDateTime();
    }
}