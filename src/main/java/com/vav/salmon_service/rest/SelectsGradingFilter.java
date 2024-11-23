package com.vav.salmon_service.rest;

import com.vav.salmon_service.entity.SelectsGrading;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record SelectsGradingFilter(List<Long> idIn, String tagContains, List<String> genderIn,
                                   LocalDateTime createdGte, LocalDateTime createdLte, LocalDate dateOfBirthGte,
                                   LocalDate dateOfBirthLte, LocalDate dateOfHatchGte, LocalDate dateOfHatchLte,
                                   LocalDate dateOfFirstFeedGte, LocalDate dateOfFirstFeedLte, Integer ageInDaysGte,
                                   Integer ageInDaysLte, Integer ageInDayDegreesGte, Integer ageInDayDegreesLte,
                                   Integer lengthAbsoluteGte, Integer lengthAbsoluteLte,
                                   Integer lengthBeforeScalesGte, Integer lengthBeforeScalesLte,
                                   Integer lengthBodyGte, Integer lengthBodyLte, Integer lengthHeadGte,
                                   Integer lengthHeadLte, Integer heightBodyGte, Integer heightBodyLte,
                                   Integer thicknessOfBackGte, Integer thicknessOfBackLte, Double fatnessFactorGte,
                                   Double fatnessFactorLte, Double headFactorGte, Double headFactorLte,
                                   Double thickFactorGte, Double thickFactorLte, Double runnabilityIndexGte,
                                   Double runnabilityIndexLte, Integer weightGte, Integer weightLte,
                                   Integer ejaculateVolumeGte, Integer ejaculateVolumeLte,
                                   Double spermConcentrationGte, Double spermConcentrationLte,
                                   Integer spermMotilityTimeGte, Integer spermMotilityTimeLte,
                                   Integer weightOfEggsGte, Integer weightOfEggsLte, Integer weightOfSingleEggGte,
                                   Integer weightOfSingleEggLte, Double caviarProportionGte,
                                   Double caviarProportionLte, Double workingFertilityGte,
                                   Double workingFertilityLte, Double reproductiveIndexGte,
                                   Double reproductiveIndexLte, Double relativeFecundityGte,
                                   Double relativeFecundityLte, Integer percentOfEggFertilizationGte,
                                   Integer percentOfEggFertilizationLte, Integer percentOfEmbryoSurvivalGte,
                                   Integer percentOfEmbryoSurvivalLte, Integer percentOfEmbryoYieldGte,
                                   Integer percentOfEmbryoYieldLte, Integer percentOfDeathToThePeepholeGte,
                                   Integer percentOfDeathToThePeepholeLte,
                                   Integer percentOfDeathAfterThePeepholeGte,
                                   Integer percentOfDeathAfterThePeepholeLte,
                                   Integer postOcularDevelopmentalAbnormalitiesGte,
                                   Integer postOcularDevelopmentalAbnormalitiesLte,
                                   Integer percentOfHatchingInTwoDaysGte, Integer percentOfHatchingInTwoDaysLte,
                                   Integer percentOfWentUpOnTheFloatGte, Integer percentOfWentUpOnTheFloatLte,
                                   Double feedFactorGte, Double feedFactorLte, String filletPigmentationContains,
                                   Integer activeFeedingSurvivalRateGte, Integer activeFeedingSurvivalRateLte,
                                   Integer diseaseResistanceGte, Integer diseaseResistanceLte,
                                   String diaryContains) {
    public Specification<SelectsGrading> toSpecification() {
        return Specification.where(idInSpec())
                .and(tagContainsSpec())
                .and(genderInSpec())
                .and(createdGteSpec())
                .and(createdLteSpec())
                .and(dateOfBirthGteSpec())
                .and(dateOfBirthLteSpec())
                .and(dateOfHatchGteSpec())
                .and(dateOfHatchLteSpec())
                .and(dateOfFirstFeedGteSpec())
                .and(dateOfFirstFeedLteSpec())
                .and(ageInDaysGteSpec())
                .and(ageInDaysLteSpec())
                .and(ageInDayDegreesGteSpec())
                .and(ageInDayDegreesLteSpec())
                .and(lengthAbsoluteGteSpec())
                .and(lengthAbsoluteLteSpec())
                .and(lengthBeforeScalesGteSpec())
                .and(lengthBeforeScalesLteSpec())
                .and(lengthBodyGteSpec())
                .and(lengthBodyLteSpec())
                .and(lengthHeadGteSpec())
                .and(lengthHeadLteSpec())
                .and(heightBodyGteSpec())
                .and(heightBodyLteSpec())
                .and(thicknessOfBackGteSpec())
                .and(thicknessOfBackLteSpec())
                .and(fatnessFactorGteSpec())
                .and(fatnessFactorLteSpec())
                .and(headFactorGteSpec())
                .and(headFactorLteSpec())
                .and(thickFactorGteSpec())
                .and(thickFactorLteSpec())
                .and(runnabilityIndexGteSpec())
                .and(runnabilityIndexLteSpec())
                .and(weightGteSpec())
                .and(weightLteSpec())
                .and(ejaculateVolumeGteSpec())
                .and(ejaculateVolumeLteSpec())
                .and(spermConcentrationGteSpec())
                .and(spermConcentrationLteSpec())
                .and(spermMotilityTimeGteSpec())
                .and(spermMotilityTimeLteSpec())
                .and(weightOfEggsGteSpec())
                .and(weightOfEggsLteSpec())
                .and(weightOfSingleEggGteSpec())
                .and(weightOfSingleEggLteSpec())
                .and(caviarProportionGteSpec())
                .and(caviarProportionLteSpec())
                .and(workingFertilityGteSpec())
                .and(workingFertilityLteSpec())
                .and(reproductiveIndexGteSpec())
                .and(reproductiveIndexLteSpec())
                .and(relativeFecundityGteSpec())
                .and(relativeFecundityLteSpec())
                .and(percentOfEggFertilizationGteSpec())
                .and(percentOfEggFertilizationLteSpec())
                .and(percentOfEmbryoSurvivalGteSpec())
                .and(percentOfEmbryoSurvivalLteSpec())
                .and(percentOfEmbryoYieldGteSpec())
                .and(percentOfEmbryoYieldLteSpec())
                .and(percentOfDeathToThePeepholeGteSpec())
                .and(percentOfDeathToThePeepholeLteSpec())
                .and(percentOfDeathAfterThePeepholeGteSpec())
                .and(percentOfDeathAfterThePeepholeLteSpec())
                .and(postOcularDevelopmentalAbnormalitiesGteSpec())
                .and(postOcularDevelopmentalAbnormalitiesLteSpec())
                .and(percentOfHatchingInTwoDaysGteSpec())
                .and(percentOfHatchingInTwoDaysLteSpec())
                .and(percentOfWentUpOnTheFloatGteSpec())
                .and(percentOfWentUpOnTheFloatLteSpec())
                .and(feedFactorGteSpec())
                .and(feedFactorLteSpec())
                .and(filletPigmentationContainsSpec())
                .and(activeFeedingSurvivalRateGteSpec())
                .and(activeFeedingSurvivalRateLteSpec())
                .and(diseaseResistanceGteSpec())
                .and(diseaseResistanceLteSpec())
                .and(diaryContainsSpec());
    }

    private Specification<SelectsGrading> idInSpec() {
        return ((root, query, cb) -> idIn != null
                ? root.get("id").in(idIn)
                : null);
    }

    private Specification<SelectsGrading> tagContainsSpec() {
        return ((root, query, cb) -> StringUtils.hasText(tagContains)
                ? cb.like(cb.lower(root.get("tag")), "%" + tagContains.toLowerCase() + "%")
                : null);
    }

    private Specification<SelectsGrading> genderInSpec() {
        return ((root, query, cb) -> genderIn != null
                ? cb.lower(root.get("gender")).in(genderIn.stream().map(String::toLowerCase).toList())
                : null);
    }

    private Specification<SelectsGrading> createdGteSpec() {
        return ((root, query, cb) -> createdGte != null
                ? cb.greaterThanOrEqualTo(root.get("created"), createdGte)
                : null);
    }

    private Specification<SelectsGrading> createdLteSpec() {
        return ((root, query, cb) -> createdLte != null
                ? cb.lessThanOrEqualTo(root.get("created"), createdLte)
                : null);
    }

    private Specification<SelectsGrading> dateOfBirthGteSpec() {
        return ((root, query, cb) -> dateOfBirthGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfBirth"), dateOfBirthGte)
                : null);
    }

    private Specification<SelectsGrading> dateOfBirthLteSpec() {
        return ((root, query, cb) -> dateOfBirthLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfBirth"), dateOfBirthLte)
                : null);
    }

    private Specification<SelectsGrading> dateOfHatchGteSpec() {
        return ((root, query, cb) -> dateOfHatchGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfHatch"), dateOfHatchGte)
                : null);
    }

    private Specification<SelectsGrading> dateOfHatchLteSpec() {
        return ((root, query, cb) -> dateOfHatchLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfHatch"), dateOfHatchLte)
                : null);
    }

    private Specification<SelectsGrading> dateOfFirstFeedGteSpec() {
        return ((root, query, cb) -> dateOfFirstFeedGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfFirstFeed"), dateOfFirstFeedGte)
                : null);
    }

    private Specification<SelectsGrading> dateOfFirstFeedLteSpec() {
        return ((root, query, cb) -> dateOfFirstFeedLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfFirstFeed"), dateOfFirstFeedLte)
                : null);
    }

    private Specification<SelectsGrading> ageInDaysGteSpec() {
        return ((root, query, cb) -> ageInDaysGte != null
                ? cb.greaterThanOrEqualTo(root.get("ageInDays"), ageInDaysGte)
                : null);
    }

    private Specification<SelectsGrading> ageInDaysLteSpec() {
        return ((root, query, cb) -> ageInDaysLte != null
                ? cb.lessThanOrEqualTo(root.get("ageInDays"), ageInDaysLte)
                : null);
    }

    private Specification<SelectsGrading> ageInDayDegreesGteSpec() {
        return ((root, query, cb) -> ageInDayDegreesGte != null
                ? cb.greaterThanOrEqualTo(root.get("ageInDayDegrees"), ageInDayDegreesGte)
                : null);
    }

    private Specification<SelectsGrading> ageInDayDegreesLteSpec() {
        return ((root, query, cb) -> ageInDayDegreesLte != null
                ? cb.lessThanOrEqualTo(root.get("ageInDayDegrees"), ageInDayDegreesLte)
                : null);
    }

    private Specification<SelectsGrading> lengthAbsoluteGteSpec() {
        return ((root, query, cb) -> lengthAbsoluteGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthAbsolute"), lengthAbsoluteGte)
                : null);
    }

    private Specification<SelectsGrading> lengthAbsoluteLteSpec() {
        return ((root, query, cb) -> lengthAbsoluteLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthAbsolute"), lengthAbsoluteLte)
                : null);
    }

    private Specification<SelectsGrading> lengthBeforeScalesGteSpec() {
        return ((root, query, cb) -> lengthBeforeScalesGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthBeforeScales"), lengthBeforeScalesGte)
                : null);
    }

    private Specification<SelectsGrading> lengthBeforeScalesLteSpec() {
        return ((root, query, cb) -> lengthBeforeScalesLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthBeforeScales"), lengthBeforeScalesLte)
                : null);
    }

    private Specification<SelectsGrading> lengthBodyGteSpec() {
        return ((root, query, cb) -> lengthBodyGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthBody"), lengthBodyGte)
                : null);
    }

    private Specification<SelectsGrading> lengthBodyLteSpec() {
        return ((root, query, cb) -> lengthBodyLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthBody"), lengthBodyLte)
                : null);
    }

    private Specification<SelectsGrading> lengthHeadGteSpec() {
        return ((root, query, cb) -> lengthHeadGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthHead"), lengthHeadGte)
                : null);
    }

    private Specification<SelectsGrading> lengthHeadLteSpec() {
        return ((root, query, cb) -> lengthHeadLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthHead"), lengthHeadLte)
                : null);
    }

    private Specification<SelectsGrading> heightBodyGteSpec() {
        return ((root, query, cb) -> heightBodyGte != null
                ? cb.greaterThanOrEqualTo(root.get("heightBody"), heightBodyGte)
                : null);
    }

    private Specification<SelectsGrading> heightBodyLteSpec() {
        return ((root, query, cb) -> heightBodyLte != null
                ? cb.lessThanOrEqualTo(root.get("heightBody"), heightBodyLte)
                : null);
    }

    private Specification<SelectsGrading> thicknessOfBackGteSpec() {
        return ((root, query, cb) -> thicknessOfBackGte != null
                ? cb.greaterThanOrEqualTo(root.get("thicknessOfBack"), thicknessOfBackGte)
                : null);
    }

    private Specification<SelectsGrading> thicknessOfBackLteSpec() {
        return ((root, query, cb) -> thicknessOfBackLte != null
                ? cb.lessThanOrEqualTo(root.get("thicknessOfBack"), thicknessOfBackLte)
                : null);
    }

    private Specification<SelectsGrading> fatnessFactorGteSpec() {
        return ((root, query, cb) -> fatnessFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("fatnessFactor"), fatnessFactorGte)
                : null);
    }

    private Specification<SelectsGrading> fatnessFactorLteSpec() {
        return ((root, query, cb) -> fatnessFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("fatnessFactor"), fatnessFactorLte)
                : null);
    }

    private Specification<SelectsGrading> headFactorGteSpec() {
        return ((root, query, cb) -> headFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("headFactor"), headFactorGte)
                : null);
    }

    private Specification<SelectsGrading> headFactorLteSpec() {
        return ((root, query, cb) -> headFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("headFactor"), headFactorLte)
                : null);
    }

    private Specification<SelectsGrading> thickFactorGteSpec() {
        return ((root, query, cb) -> thickFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("thickFactor"), thickFactorGte)
                : null);
    }

    private Specification<SelectsGrading> thickFactorLteSpec() {
        return ((root, query, cb) -> thickFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("thickFactor"), thickFactorLte)
                : null);
    }

    private Specification<SelectsGrading> runnabilityIndexGteSpec() {
        return ((root, query, cb) -> runnabilityIndexGte != null
                ? cb.greaterThanOrEqualTo(root.get("runnabilityIndex"), runnabilityIndexGte)
                : null);
    }

    private Specification<SelectsGrading> runnabilityIndexLteSpec() {
        return ((root, query, cb) -> runnabilityIndexLte != null
                ? cb.lessThanOrEqualTo(root.get("runnabilityIndex"), runnabilityIndexLte)
                : null);
    }

    private Specification<SelectsGrading> weightGteSpec() {
        return ((root, query, cb) -> weightGte != null
                ? cb.greaterThanOrEqualTo(root.get("weight"), weightGte)
                : null);
    }

    private Specification<SelectsGrading> weightLteSpec() {
        return ((root, query, cb) -> weightLte != null
                ? cb.lessThanOrEqualTo(root.get("weight"), weightLte)
                : null);
    }

    private Specification<SelectsGrading> ejaculateVolumeGteSpec() {
        return ((root, query, cb) -> ejaculateVolumeGte != null
                ? cb.greaterThanOrEqualTo(root.get("ejaculateVolume"), ejaculateVolumeGte)
                : null);
    }

    private Specification<SelectsGrading> ejaculateVolumeLteSpec() {
        return ((root, query, cb) -> ejaculateVolumeLte != null
                ? cb.lessThanOrEqualTo(root.get("ejaculateVolume"), ejaculateVolumeLte)
                : null);
    }

    private Specification<SelectsGrading> spermConcentrationGteSpec() {
        return ((root, query, cb) -> spermConcentrationGte != null
                ? cb.greaterThanOrEqualTo(root.get("spermConcentration"), spermConcentrationGte)
                : null);
    }

    private Specification<SelectsGrading> spermConcentrationLteSpec() {
        return ((root, query, cb) -> spermConcentrationLte != null
                ? cb.lessThanOrEqualTo(root.get("spermConcentration"), spermConcentrationLte)
                : null);
    }

    private Specification<SelectsGrading> spermMotilityTimeGteSpec() {
        return ((root, query, cb) -> spermMotilityTimeGte != null
                ? cb.greaterThanOrEqualTo(root.get("spermMotilityTime"), spermMotilityTimeGte)
                : null);
    }

    private Specification<SelectsGrading> spermMotilityTimeLteSpec() {
        return ((root, query, cb) -> spermMotilityTimeLte != null
                ? cb.lessThanOrEqualTo(root.get("spermMotilityTime"), spermMotilityTimeLte)
                : null);
    }

    private Specification<SelectsGrading> weightOfEggsGteSpec() {
        return ((root, query, cb) -> weightOfEggsGte != null
                ? cb.greaterThanOrEqualTo(root.get("weightOfEggs"), weightOfEggsGte)
                : null);
    }

    private Specification<SelectsGrading> weightOfEggsLteSpec() {
        return ((root, query, cb) -> weightOfEggsLte != null
                ? cb.lessThanOrEqualTo(root.get("weightOfEggs"), weightOfEggsLte)
                : null);
    }

    private Specification<SelectsGrading> weightOfSingleEggGteSpec() {
        return ((root, query, cb) -> weightOfSingleEggGte != null
                ? cb.greaterThanOrEqualTo(root.get("weightOfSingleEgg"), weightOfSingleEggGte)
                : null);
    }

    private Specification<SelectsGrading> weightOfSingleEggLteSpec() {
        return ((root, query, cb) -> weightOfSingleEggLte != null
                ? cb.lessThanOrEqualTo(root.get("weightOfSingleEgg"), weightOfSingleEggLte)
                : null);
    }

    private Specification<SelectsGrading> caviarProportionGteSpec() {
        return ((root, query, cb) -> caviarProportionGte != null
                ? cb.greaterThanOrEqualTo(root.get("caviarProportion"), caviarProportionGte)
                : null);
    }

    private Specification<SelectsGrading> caviarProportionLteSpec() {
        return ((root, query, cb) -> caviarProportionLte != null
                ? cb.lessThanOrEqualTo(root.get("caviarProportion"), caviarProportionLte)
                : null);
    }

    private Specification<SelectsGrading> workingFertilityGteSpec() {
        return ((root, query, cb) -> workingFertilityGte != null
                ? cb.greaterThanOrEqualTo(root.get("workingFertility"), workingFertilityGte)
                : null);
    }

    private Specification<SelectsGrading> workingFertilityLteSpec() {
        return ((root, query, cb) -> workingFertilityLte != null
                ? cb.lessThanOrEqualTo(root.get("workingFertility"), workingFertilityLte)
                : null);
    }

    private Specification<SelectsGrading> reproductiveIndexGteSpec() {
        return ((root, query, cb) -> reproductiveIndexGte != null
                ? cb.greaterThanOrEqualTo(root.get("reproductiveIndex"), reproductiveIndexGte)
                : null);
    }

    private Specification<SelectsGrading> reproductiveIndexLteSpec() {
        return ((root, query, cb) -> reproductiveIndexLte != null
                ? cb.lessThanOrEqualTo(root.get("reproductiveIndex"), reproductiveIndexLte)
                : null);
    }

    private Specification<SelectsGrading> relativeFecundityGteSpec() {
        return ((root, query, cb) -> relativeFecundityGte != null
                ? cb.greaterThanOrEqualTo(root.get("relativeFecundity"), relativeFecundityGte)
                : null);
    }

    private Specification<SelectsGrading> relativeFecundityLteSpec() {
        return ((root, query, cb) -> relativeFecundityLte != null
                ? cb.lessThanOrEqualTo(root.get("relativeFecundity"), relativeFecundityLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfEggFertilizationGteSpec() {
        return ((root, query, cb) -> percentOfEggFertilizationGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfEggFertilization"), percentOfEggFertilizationGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfEggFertilizationLteSpec() {
        return ((root, query, cb) -> percentOfEggFertilizationLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfEggFertilization"), percentOfEggFertilizationLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfEmbryoSurvivalGteSpec() {
        return ((root, query, cb) -> percentOfEmbryoSurvivalGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfEmbryoSurvival"), percentOfEmbryoSurvivalGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfEmbryoSurvivalLteSpec() {
        return ((root, query, cb) -> percentOfEmbryoSurvivalLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfEmbryoSurvival"), percentOfEmbryoSurvivalLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfEmbryoYieldGteSpec() {
        return ((root, query, cb) -> percentOfEmbryoYieldGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfEmbryoYield"), percentOfEmbryoYieldGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfEmbryoYieldLteSpec() {
        return ((root, query, cb) -> percentOfEmbryoYieldLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfEmbryoYield"), percentOfEmbryoYieldLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfDeathToThePeepholeGteSpec() {
        return ((root, query, cb) -> percentOfDeathToThePeepholeGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfDeathToThePeephole"), percentOfDeathToThePeepholeGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfDeathToThePeepholeLteSpec() {
        return ((root, query, cb) -> percentOfDeathToThePeepholeLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfDeathToThePeephole"), percentOfDeathToThePeepholeLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfDeathAfterThePeepholeGteSpec() {
        return ((root, query, cb) -> percentOfDeathAfterThePeepholeGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfDeathAfterThePeephole"), percentOfDeathAfterThePeepholeGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfDeathAfterThePeepholeLteSpec() {
        return ((root, query, cb) -> percentOfDeathAfterThePeepholeLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfDeathAfterThePeephole"), percentOfDeathAfterThePeepholeLte)
                : null);
    }

    private Specification<SelectsGrading> postOcularDevelopmentalAbnormalitiesGteSpec() {
        return ((root, query, cb) -> postOcularDevelopmentalAbnormalitiesGte != null
                ? cb.greaterThanOrEqualTo(root.get("postOcularDevelopmentalAbnormalities"), postOcularDevelopmentalAbnormalitiesGte)
                : null);
    }

    private Specification<SelectsGrading> postOcularDevelopmentalAbnormalitiesLteSpec() {
        return ((root, query, cb) -> postOcularDevelopmentalAbnormalitiesLte != null
                ? cb.lessThanOrEqualTo(root.get("postOcularDevelopmentalAbnormalities"), postOcularDevelopmentalAbnormalitiesLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfHatchingInTwoDaysGteSpec() {
        return ((root, query, cb) -> percentOfHatchingInTwoDaysGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfHatchingInTwoDays"), percentOfHatchingInTwoDaysGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfHatchingInTwoDaysLteSpec() {
        return ((root, query, cb) -> percentOfHatchingInTwoDaysLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfHatchingInTwoDays"), percentOfHatchingInTwoDaysLte)
                : null);
    }

    private Specification<SelectsGrading> percentOfWentUpOnTheFloatGteSpec() {
        return ((root, query, cb) -> percentOfWentUpOnTheFloatGte != null
                ? cb.greaterThanOrEqualTo(root.get("percentOfWentUpOnTheFloat"), percentOfWentUpOnTheFloatGte)
                : null);
    }

    private Specification<SelectsGrading> percentOfWentUpOnTheFloatLteSpec() {
        return ((root, query, cb) -> percentOfWentUpOnTheFloatLte != null
                ? cb.lessThanOrEqualTo(root.get("percentOfWentUpOnTheFloat"), percentOfWentUpOnTheFloatLte)
                : null);
    }

    private Specification<SelectsGrading> feedFactorGteSpec() {
        return ((root, query, cb) -> feedFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("feedFactor"), feedFactorGte)
                : null);
    }

    private Specification<SelectsGrading> feedFactorLteSpec() {
        return ((root, query, cb) -> feedFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("feedFactor"), feedFactorLte)
                : null);
    }

    private Specification<SelectsGrading> filletPigmentationContainsSpec() {
        return ((root, query, cb) -> StringUtils.hasText(filletPigmentationContains)
                ? cb.like(cb.lower(root.get("filletPigmentation")), "%" + filletPigmentationContains.toLowerCase() + "%")
                : null);
    }

    private Specification<SelectsGrading> activeFeedingSurvivalRateGteSpec() {
        return ((root, query, cb) -> activeFeedingSurvivalRateGte != null
                ? cb.greaterThanOrEqualTo(root.get("activeFeedingSurvivalRate"), activeFeedingSurvivalRateGte)
                : null);
    }

    private Specification<SelectsGrading> activeFeedingSurvivalRateLteSpec() {
        return ((root, query, cb) -> activeFeedingSurvivalRateLte != null
                ? cb.lessThanOrEqualTo(root.get("activeFeedingSurvivalRate"), activeFeedingSurvivalRateLte)
                : null);
    }

    private Specification<SelectsGrading> diseaseResistanceGteSpec() {
        return ((root, query, cb) -> diseaseResistanceGte != null
                ? cb.greaterThanOrEqualTo(root.get("diseaseResistance"), diseaseResistanceGte)
                : null);
    }

    private Specification<SelectsGrading> diseaseResistanceLteSpec() {
        return ((root, query, cb) -> diseaseResistanceLte != null
                ? cb.lessThanOrEqualTo(root.get("diseaseResistance"), diseaseResistanceLte)
                : null);
    }

    private Specification<SelectsGrading> diaryContainsSpec() {
        return ((root, query, cb) -> StringUtils.hasText(diaryContains)
                ? cb.like(cb.lower(root.get("diary")), "%" + diaryContains.toLowerCase() + "%")
                : null);
    }
}