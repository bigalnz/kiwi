package com.nz.kiwi.mapper;

import com.nz.kiwi.dto.HealthCheckListDTO;
import com.nz.kiwi.dto.HealthCheckViewDTO;
import com.nz.kiwi.model.Bird;
import com.nz.kiwi.model.HealthCheck;
import com.nz.kiwi.model.Transmitter;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HealthCheckMapper {

    @Mapping(source = "bird.name", target = "name")
    HealthCheckListDTO healthCheckToHealthCheckListDTO(HealthCheck healthCheck);

    //@Mapping(target = "bird.listHealthCheck", ignore = true)
    @Mapping(source = "healthCheck.bird.name", target = "name")
    @Mapping(source = "healthCheck.id", target = "id")
    @Mapping(source = "healthCheck.location.x", target = "latitude")
    @Mapping(source = "healthCheck.location.y", target = "longitude")
    HealthCheckViewDTO healthCheckToHealthCheckViewDTO(HealthCheck healthCheck, Transmitter transmitter);

    //HealthCheckViewDTO healthCheckToHealthCheckViewDTOTest(HealthCheck healthCheck, Transmitter transmitter);

}
