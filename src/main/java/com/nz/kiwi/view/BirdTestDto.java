package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.HealthCheck;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Value
@Getter
public class BirdTestDto implements Serializable {

    private String name;
    private Status status;
    private Sex sex;
    private Collection<HealthCheck> healthCheckList;

    public BirdTestDto(String name, Status status, Sex sex, Collection<HealthCheck> healthCheckList) {
        this.name = name;
        this.status = status;
        this.sex = sex;
        this.healthCheckList = healthCheckList;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Sex getSex() {
        return sex;
    }

    public Collection<HealthCheck> getHealthCheckList() {
        return healthCheckList;
    }
}
