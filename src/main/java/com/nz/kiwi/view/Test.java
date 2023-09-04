package com.nz.kiwi.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nz.kiwi.model.HealthCheck;
import lombok.*;
import org.geolatte.geom.json.GeolatteGeomModule;
import org.hibernate.annotations.Imported;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Imported
@Data
public class Test {

    public Long id;
    public String name;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm")
    //public LocalDateTime healthCheckDateTime;
    public HealthCheckDto healthCheckDto;
}
