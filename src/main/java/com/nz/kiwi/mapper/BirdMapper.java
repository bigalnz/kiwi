package com.nz.kiwi.mapper;

import com.nz.kiwi.dto.BirdDTO;
import com.nz.kiwi.dto.BirdViewDTO;
import com.nz.kiwi.model.Bird;
import org.mapstruct.*;

@MapperConfig(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
@Mapper(componentModel = "spring")
public interface BirdMapper {

    //@Mapping(source = "bird.listHealthCheck", target = "listHealthCheck")
    //@Mapping(target = "listHealthCheck.name", ignore = true)
    BirdViewDTO birdToBirdViewDTO(Bird bird);

    BirdDTO birdToBirdDTO(Bird bird);

}
