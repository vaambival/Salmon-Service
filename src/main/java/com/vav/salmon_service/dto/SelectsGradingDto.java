package com.vav.salmon_service.dto;

import com.vav.salmon_service.entity.SelectsGrading;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link SelectsGrading}
 */
public record SelectsGradingDto(Long id, String tag, String gender, LocalDateTime created, LocalDate dateOfBirth, LocalDate dateOfHatch,
                                LocalDate dateOfFirstFeed, Integer ageInDays, Integer ageInDayDegrees, Integer lengthAbsolute,
                                Integer lengthBeforeScales, Integer lengthBody, Integer lengthHead, Integer heightBody,
                                Integer thicknessOfBack, Double fatnessFactor, Double headFactor, Double thickFactor,
                                Double runnabilityIndex, Integer weight, Integer ejaculateVolume, Double spermConcentration,
                                Integer spermMotilityTime, Integer weightOfEggs, Integer weightOfSingleEgg, Double caviarProportion,
                                Double workingFertility, Double reproductiveIndex, Double relativeFecundity, Integer percentOfEggFertilization,
                                Integer percentOfEmbryoSurvival, Integer percentOfEmbryoYield, Integer percentOfDeathToThePeephole,
                                Integer percentOfDeathAfterThePeephole, Integer postOcularDevelopmentalAbnormalities, Integer percentOfHatchingInTwoDays,
                                Integer percentOfWentUpOnTheFloat, Double feedFactor, String filletPigmentation, Integer activeFeedingSurvivalRate,
                                Integer diseaseResistance, String diary) {
}