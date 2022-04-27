package com.nz.kiwi.mapper;

import com.nz.kiwi.dto.TransmitterDTO;
import com.nz.kiwi.dto.TransmitterOnHealthCheckDTO;
import com.nz.kiwi.model.Transmitter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

@MapperConfig(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
@Mapper(componentModel = "spring")
public interface TransmitterMapper {

    TransmitterDTO transmitterToTransmitterDTO(Transmitter transmitter);
    TransmitterOnHealthCheckDTO transmitterToTransmitterOnHealthCheckDTO(Transmitter transmitter);

}
