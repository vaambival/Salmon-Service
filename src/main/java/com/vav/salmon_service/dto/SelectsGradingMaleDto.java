package com.vav.salmon_service.dto;

import java.time.LocalDate;

/**
 * DTO for {@link com.vav.salmon_service.entity.SelectsGradingMale}
 */
public record SelectsGradingMaleDto(Long id, String marker, LocalDate dateOfBirth, LocalDate dateOfHatching,
                                    LocalDate dateOfStartFeeding, Integer estimatedAgeDays,
                                    Integer estimatedAgeDegreeDays, Integer absoluteLength,
                                    Integer bodyLengthBeforeEndScaleCover, Integer bodyLength, Integer headLength,
                                    Integer bodyHeight, Integer backThickness, Double fatnessIndex, Double headIndex,
                                    Double thicknessIndex, Double indexRunnability,Integer ejaculateVolume, Double spermatocritValue,
                                    Integer spermMotilityTime, String diary) {
}