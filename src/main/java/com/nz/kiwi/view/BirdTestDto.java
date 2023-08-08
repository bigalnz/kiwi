package com.nz.kiwi.view;

import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Status;
import com.nz.kiwi.model.HealthCheck;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Value
public class BirdTestDto implements Serializable {

    private String name;
    private Sex sex;
    private Status status;
    private List<HealthCheck> listHealthCheckDto;

    public BirdTestDto(String name, Sex sex, Status status, List<HealthCheck> listHealthCheckDto) {
        this.name = name;
        this.sex = sex;
        this.status = status;
        this.listHealthCheckDto = listHealthCheckDto;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Status getStatus() {
        return status;
    }

    public List<HealthCheck> getListHealthCheckDto() {
        return listHealthCheckDto;
    }
}
