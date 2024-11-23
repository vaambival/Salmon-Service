package com.vav.salmon_service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.vav.salmon_service.entity.SelectsGradingMale}
 */
public record SelectsGradingMaleDto(Long id, String tag, LocalDateTime created, LocalDate dateOfBirth, LocalDate dateOfHatch,
                                    LocalDate dateOfFirstFeed, Integer ageInDays, Integer ageInDayDegrees, Integer lengthAbsolute,
                                    Integer lengthBeforeScales, Integer lengthBody, Integer lengthHead, Integer heightBody,
                                    Integer thicknessOfBack, Double fatnessFactor, Double headFactor, Double thickFactor,
                                    Double runnabilityIndex, Integer ejaculateVolume, Double spermConcentration, Integer spermMotilityTime,





                                    String diary) {
}