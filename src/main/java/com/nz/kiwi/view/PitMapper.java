package com.nz.kiwi.view;

import com.nz.kiwi.model.Pit;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PitMapper {
    Pit toEntity(PitDto pitDto);

    PitDto toDto(Pit pit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pit partialUpdate(PitDto pitDto, @MappingTarget Pit pit);
}