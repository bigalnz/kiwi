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
    private Collection<HealthCheckDto> listHealthCheckDto = new ArrayList<>();

}
