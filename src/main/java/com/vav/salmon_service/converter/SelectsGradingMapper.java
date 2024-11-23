package com.vav.salmon_service.converter;

import com.vav.salmon_service.dto.SelectsGradingDto;
import com.vav.salmon_service.entity.SelectsGrading;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface SelectsGradingMapper {
    SelectsGrading toEntity(SelectsGradingDto selectsGradingDto);

    SelectsGradingDto toDto(SelectsGrading selectsGrading);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    SelectsGrading partialUpdate(SelectsGradingDto selectsGradingDto, @org.mapstruct.MappingTarget SelectsGrading selectsGrading);

    SelectsGrading updateWithNull(SelectsGradingDto selectsGradingDto, @MappingTarget SelectsGrading selectsGrading);
}