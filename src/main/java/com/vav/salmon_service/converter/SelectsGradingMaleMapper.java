package com.vav.salmon_service.converter;

import com.vav.salmon_service.dto.SelectsGradingMaleDto;
import com.vav.salmon_service.entity.SelectsGradingMale;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface SelectsGradingMaleMapper {
    SelectsGradingMale toEntity(SelectsGradingMaleDto selectsGradingMaleDto);

    SelectsGradingMaleDto toDto(SelectsGradingMale selectsGradingMale);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    SelectsGradingMale partialUpdate(SelectsGradingMaleDto selectsGradingMaleDto, @org.mapstruct.MappingTarget SelectsGradingMale selectsGradingMale);
}