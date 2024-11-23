package com.vav.salmon_service.rest;

import com.vav.salmon_service.entity.SelectsGradingMale;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SelectsGradingMaleFilter(String tag, LocalDate dateOfBirthGte, LocalDate dateOfBirthLte,
                                       LocalDate dateOfHatchGte, LocalDate dateOfHatchLte,
                                       LocalDate dateOfFirstFeedGte, LocalDate dateOfFirstFeedLte,
                                       Integer ageInDaysGte, Integer ageInDaysLte,
                                       Integer ageInDayDegreesGte, Integer ageInDayDegreesLte,
                                       Integer lengthAbsoluteGte, Integer lengthAbsoluteLte,
                                       Integer lengthBeforeScalesGte,
                                       Integer lengthBeforeScalesLte, Integer lengthBodyGte,
                                       Integer lengthBodyLte, Integer lengthHeadGte, Integer lengthHeadLte,
                                       Integer heightBodyGte, Integer heightBodyLte, Integer thicknessOfBackGte,
                                       Integer thicknessOfBackLte, Double fatnessFactorGte, Double fatnessFactorLte,
                                       Double headFactorGte, Double headFactorLte, Double thickFactorGte,
                                       Double thickFactorLte, Integer ejaculateVolumeGte,
                                       Double runnabilityIndexLte, Integer runnabilityIndexGte,
                                       Integer ejaculateVolumeLte,
                                       Double spermConcentrationGte, Double spermConcentrationLte,
                                       Integer spermMotilityTimeGte, Integer spermMotilityTimeLte,
                                       LocalDateTime createdGte, LocalDateTime createdLte) {
    public Specification<SelectsGradingMale> toSpecification() {
        return Specification.where(markerContainsSpec())
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
                .and(runnabilityIndexLteSpec())
                .and(runnabilityIndexGteSpec())
                .and(ejaculateVolumeGteSpec())
                .and(ejaculateVolumeLteSpec())
                .and(spermConcentrationGteSpec())
                .and(spermConcentrationLteSpec())
                .and(spermMotilityTimeGteSpec())
                .and(spermMotilityTimeLteSpec());
    }

    private Specification<SelectsGradingMale> createdGteSpec() {
        return (root, query, criteriaBuilder) -> createdGte != null ?
                criteriaBuilder.greaterThanOrEqualTo(root.get("created"), createdGte) : null;
    }

    private Specification<SelectsGradingMale> createdLteSpec() {
        return (root, query, criteriaBuilder) -> createdLte != null ?
                criteriaBuilder.lessThanOrEqualTo(root.get("created"), createdLte) : null;
    }

    private Specification<SelectsGradingMale> markerContainsSpec() {
        return ((root, query, cb) -> StringUtils.hasText(tag)
                ? cb.like(root.get("marker"), "%" + tag + "%")
                : null);
    }

    private Specification<SelectsGradingMale> dateOfBirthGteSpec() {
        return ((root, query, cb) -> dateOfBirthGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfBirth"), dateOfBirthGte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfBirthLteSpec() {
        return ((root, query, cb) -> dateOfBirthLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfBirth"), dateOfBirthLte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfHatchGteSpec() {
        return ((root, query, cb) -> dateOfHatchGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfHatch"), dateOfHatchGte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfHatchLteSpec() {
        return ((root, query, cb) -> dateOfHatchLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfHatch"), dateOfHatchLte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfFirstFeedGteSpec() {
        return ((root, query, cb) -> dateOfFirstFeedGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfFirstFeed"), dateOfFirstFeedGte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfFirstFeedLteSpec() {
        return ((root, query, cb) -> dateOfFirstFeedLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfFirstFeed"), dateOfFirstFeedLte)
                : null);
    }

    private Specification<SelectsGradingMale> ageInDaysGteSpec() {
        return ((root, query, cb) -> ageInDaysGte != null
                ? cb.greaterThanOrEqualTo(root.get("ageInDays"), ageInDaysGte)
                : null);
    }

    private Specification<SelectsGradingMale> ageInDaysLteSpec() {
        return ((root, query, cb) -> ageInDaysLte != null
                ? cb.lessThanOrEqualTo(root.get("ageInDays"), ageInDaysLte)
                : null);
    }

    private Specification<SelectsGradingMale> ageInDayDegreesGteSpec() {
        return ((root, query, cb) -> ageInDayDegreesGte != null
                ? cb.greaterThanOrEqualTo(root.get("ageInDayDegrees"), ageInDayDegreesGte)
                : null);
    }

    private Specification<SelectsGradingMale> ageInDayDegreesLteSpec() {
        return ((root, query, cb) -> ageInDayDegreesLte != null
                ? cb.lessThanOrEqualTo(root.get("ageInDayDegrees"), ageInDayDegreesLte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthAbsoluteGteSpec() {
        return ((root, query, cb) -> lengthAbsoluteGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthAbsolute"), lengthAbsoluteGte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthAbsoluteLteSpec() {
        return ((root, query, cb) -> lengthAbsoluteLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthAbsolute"), lengthAbsoluteLte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthBeforeScalesGteSpec() {
        return ((root, query, cb) -> lengthBeforeScalesGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthBeforeScales"), lengthBeforeScalesGte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthBeforeScalesLteSpec() {
        return ((root, query, cb) -> lengthBeforeScalesLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthBeforeScales"), lengthBeforeScalesLte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthBodyGteSpec() {
        return ((root, query, cb) -> lengthBodyGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthBody"), lengthBodyGte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthBodyLteSpec() {
        return ((root, query, cb) -> lengthBodyLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthBody"), lengthBodyLte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthHeadGteSpec() {
        return ((root, query, cb) -> lengthHeadGte != null
                ? cb.greaterThanOrEqualTo(root.get("lengthHead"), lengthHeadGte)
                : null);
    }

    private Specification<SelectsGradingMale> lengthHeadLteSpec() {
        return ((root, query, cb) -> lengthHeadLte != null
                ? cb.lessThanOrEqualTo(root.get("lengthHead"), lengthHeadLte)
                : null);
    }

    private Specification<SelectsGradingMale> heightBodyGteSpec() {
        return ((root, query, cb) -> heightBodyGte != null
                ? cb.greaterThanOrEqualTo(root.get("heightBody"), heightBodyGte)
                : null);
    }

    private Specification<SelectsGradingMale> heightBodyLteSpec() {
        return ((root, query, cb) -> heightBodyLte != null
                ? cb.lessThanOrEqualTo(root.get("heightBody"), heightBodyLte)
                : null);
    }

    private Specification<SelectsGradingMale> thicknessOfBackGteSpec() {
        return ((root, query, cb) -> thicknessOfBackGte != null
                ? cb.greaterThanOrEqualTo(root.get("thicknessOfBack"), thicknessOfBackGte)
                : null);
    }

    private Specification<SelectsGradingMale> thicknessOfBackLteSpec() {
        return ((root, query, cb) -> thicknessOfBackLte != null
                ? cb.lessThanOrEqualTo(root.get("thicknessOfBack"), thicknessOfBackLte)
                : null);
    }

    private Specification<SelectsGradingMale> fatnessFactorGteSpec() {
        return ((root, query, cb) -> fatnessFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("fatnessFactor"), fatnessFactorGte)
                : null);
    }

    private Specification<SelectsGradingMale> fatnessFactorLteSpec() {
        return ((root, query, cb) -> fatnessFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("fatnessFactor"), fatnessFactorLte)
                : null);
    }

    private Specification<SelectsGradingMale> headFactorGteSpec() {
        return ((root, query, cb) -> headFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("headFactor"), headFactorGte)
                : null);
    }

    private Specification<SelectsGradingMale> headFactorLteSpec() {
        return ((root, query, cb) -> headFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("headFactor"), headFactorLte)
                : null);
    }

    private Specification<SelectsGradingMale> thickFactorGteSpec() {
        return ((root, query, cb) -> thickFactorGte != null
                ? cb.greaterThanOrEqualTo(root.get("thickFactor"), thickFactorGte)
                : null);
    }

    private Specification<SelectsGradingMale> thickFactorLteSpec() {
        return ((root, query, cb) -> thickFactorLte != null
                ? cb.lessThanOrEqualTo(root.get("thickFactor"), thickFactorLte)
                : null);
    }

    private Specification<SelectsGradingMale> runnabilityIndexGteSpec() {
        return ((root, query, cb) -> runnabilityIndexGte != null
                ? cb.greaterThanOrEqualTo(root.get("runnabilityIndex"), runnabilityIndexGte)
                : null);
    }

    private Specification<SelectsGradingMale> runnabilityIndexLteSpec() {
        return ((root, query, cb) -> runnabilityIndexLte != null
                ? cb.lessThanOrEqualTo(root.get("runnabilityIndex"), runnabilityIndexLte)
                : null);
    }

    private Specification<SelectsGradingMale> ejaculateVolumeGteSpec() {
        return ((root, query, cb) -> ejaculateVolumeGte != null
                ? cb.greaterThanOrEqualTo(root.get("ejaculateVolume"), ejaculateVolumeGte)
                : null);
    }

    private Specification<SelectsGradingMale> ejaculateVolumeLteSpec() {
        return ((root, query, cb) -> ejaculateVolumeLte != null
                ? cb.lessThanOrEqualTo(root.get("ejaculateVolume"), ejaculateVolumeLte)
                : null);
    }

    private Specification<SelectsGradingMale> spermConcentrationGteSpec() {
        return ((root, query, cb) -> spermConcentrationGte != null
                ? cb.greaterThanOrEqualTo(root.get("spermConcentration"), spermConcentrationGte)
                : null);
    }

    private Specification<SelectsGradingMale> spermConcentrationLteSpec() {
        return ((root, query, cb) -> spermConcentrationLte != null
                ? cb.lessThanOrEqualTo(root.get("spermConcentration"), spermConcentrationLte)
                : null);
    }

    private Specification<SelectsGradingMale> spermMotilityTimeGteSpec() {
        return ((root, query, cb) -> spermMotilityTimeGte != null
                ? cb.greaterThanOrEqualTo(root.get("spermMotilityTime"), spermMotilityTimeGte)
                : null);
    }

    private Specification<SelectsGradingMale> spermMotilityTimeLteSpec() {
        return ((root, query, cb) -> spermMotilityTimeLte != null
                ? cb.lessThanOrEqualTo(root.get("spermMotilityTime"), spermMotilityTimeLte)
                : null);
    }
}