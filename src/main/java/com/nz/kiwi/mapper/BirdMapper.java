package com.nz.kiwi.mapper;

import com.nz.kiwi.model.Bird;
import com.nz.kiwi.view.BirdCreateDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BirdMapper {
    Bird toEntity(BirdCreateDto birdCreateDto);

    BirdCreateDto toDto(Bird bird);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(BirdCreateDto birdCreateDto, @MappingTarget Bird bird);
}