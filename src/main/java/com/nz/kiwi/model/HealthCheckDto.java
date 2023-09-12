package com.nz.kiwi.model;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link HealthCheck}
 */
@Value
public class HealthCheckDto implements Serializable {
    Long id;
}