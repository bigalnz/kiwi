package com.nz.kiwi.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Imported;

@AllArgsConstructor
@NoArgsConstructor
@Imported
@Data
public class Test {

    public Long id;
    public String name;
    public HealthCheckDto healthCheckDto;
}
