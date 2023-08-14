package com.nz.kiwi.view;

import com.nz.kiwi.model.HealthCheck;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link HealthCheck}
 */
@Value
public class HealthCheckDto implements Serializable {

    LocalDateTime catchDateTime;

    public HealthCheckDto(LocalDateTime catchDateTime) {
        this.catchDateTime = catchDateTime;
    }

    public LocalDateTime getCatchDateTime() {
        return catchDateTime;
    }
}