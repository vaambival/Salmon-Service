package com.vav.salmon_service.rest;

import com.vav.salmon_service.entity.SelectsGradingMale;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SelectsGradingMaleFilter(String markerContains, LocalDate dateOfBirthGte, LocalDate dateOfBirthLte,
                                       LocalDate dateOfMarkGte, LocalDate dateOfMarkLte,
                                       LocalDate dateOfHatchingGte, LocalDate dateOfHatchingLte,
                                       LocalDate dateOfStartFeedingGte, LocalDate dateOfStartFeedingLte,
                                       Integer estimatedAgeDaysGte, Integer estimatedAgeDaysLte,
                                       Integer estimatedAgeDegreeDaysGte, Integer estimatedAgeDegreeDaysLte,
                                       Integer absoluteLengthGte, Integer absoluteLengthLte,
                                       Integer bodyLengthBeforeEndScaleCoverGte,
                                       Integer bodyLengthBeforeEndScaleCoverLte, Integer bodyLengthGte,
                                       Integer bodyLengthLte, Integer headLengthGte, Integer headLengthLte,
                                       Integer bodyHeightGte, Integer bodyHeightLte, Integer backThicknessGte,
                                       Integer backThicknessLte, Double fatnessIndexGte, Double fatnessIndexLte,
                                       Double headIndexGte, Double headIndexLte, Double thicknessIndexGte,
                                       Double thicknessIndexLte, Integer ejaculateVolumeGte,
                                       Double indexRunnabilityLte, Integer indexRunnabilityGte,
                                       Integer ejaculateVolumeLte,
                                       Double spermatocritValueGte, Double spermatocritValueLte,
                                       Integer spermMotilityTimeGte, Integer spermMotilityTimeLte,
                                       LocalDateTime createdGte, LocalDateTime createdLte) {
    public Specification<SelectsGradingMale> toSpecification() {
        return Specification.where(markerContainsSpec())
                .and(dateOfMarkGteSpec())
                .and(dateOfMarkLteSpec())
                .and(dateOfBirthGteSpec())
                .and(dateOfBirthLteSpec())
                .and(dateOfHatchingGteSpec())
                .and(dateOfHatchingLteSpec())
                .and(dateOfStartFeedingGteSpec())
                .and(dateOfStartFeedingLteSpec())
                .and(estimatedAgeDaysGteSpec())
                .and(estimatedAgeDaysLteSpec())
                .and(estimatedAgeDegreeDaysGteSpec())
                .and(estimatedAgeDegreeDaysLteSpec())
                .and(absoluteLengthGteSpec())
                .and(absoluteLengthLteSpec())
                .and(bodyLengthBeforeEndScaleCoverGteSpec())
                .and(bodyLengthBeforeEndScaleCoverLteSpec())
                .and(bodyLengthGteSpec())
                .and(bodyLengthLteSpec())
                .and(headLengthGteSpec())
                .and(headLengthLteSpec())
                .and(bodyHeightGteSpec())
                .and(bodyHeightLteSpec())
                .and(backThicknessGteSpec())
                .and(backThicknessLteSpec())
                .and(fatnessIndexGteSpec())
                .and(fatnessIndexLteSpec())
                .and(headIndexGteSpec())
                .and(headIndexLteSpec())
                .and(thicknessIndexGteSpec())
                .and(thicknessIndexLteSpec())
                .and(indexRunnabilityLteSpec())
                .and(indexRunnabilityGteSpec())
                .and(ejaculateVolumeGteSpec())
                .and(ejaculateVolumeLteSpec())
                .and(spermatocritValueGteSpec())
                .and(spermatocritValueLteSpec())
                .and(spermMotilityTimeGteSpec())
                .and(spermMotilityTimeLteSpec())
                .and(createdGteSpec())
                .and(createdLteSpec());
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
        return ((root, query, cb) -> StringUtils.hasText(markerContains)
                ? cb.like(root.get("marker"), "%" + markerContains + "%")
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

    private Specification<SelectsGradingMale> dateOfHatchingGteSpec() {
        return ((root, query, cb) -> dateOfHatchingGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfHatching"), dateOfHatchingGte)
                : null);
    }
    private Specification<SelectsGradingMale> dateOfMarkLteSpec() {
        return ((root, query, cb) -> dateOfMarkLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfMark"), dateOfMarkLte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfMarkGteSpec() {
        return ((root, query, cb) -> dateOfMarkGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfMark"), dateOfMarkGte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfHatchingLteSpec() {
        return ((root, query, cb) -> dateOfHatchingLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfHatching"), dateOfHatchingLte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfStartFeedingGteSpec() {
        return ((root, query, cb) -> dateOfStartFeedingGte != null
                ? cb.greaterThanOrEqualTo(root.get("dateOfStartFeeding"), dateOfStartFeedingGte)
                : null);
    }

    private Specification<SelectsGradingMale> dateOfStartFeedingLteSpec() {
        return ((root, query, cb) -> dateOfStartFeedingLte != null
                ? cb.lessThanOrEqualTo(root.get("dateOfStartFeeding"), dateOfStartFeedingLte)
                : null);
    }

    private Specification<SelectsGradingMale> estimatedAgeDaysGteSpec() {
        return ((root, query, cb) -> estimatedAgeDaysGte != null
                ? cb.greaterThanOrEqualTo(root.get("estimatedAgeDays"), estimatedAgeDaysGte)
                : null);
    }

    private Specification<SelectsGradingMale> estimatedAgeDaysLteSpec() {
        return ((root, query, cb) -> estimatedAgeDaysLte != null
                ? cb.lessThanOrEqualTo(root.get("estimatedAgeDays"), estimatedAgeDaysLte)
                : null);
    }

    private Specification<SelectsGradingMale> estimatedAgeDegreeDaysGteSpec() {
        return ((root, query, cb) -> estimatedAgeDegreeDaysGte != null
                ? cb.greaterThanOrEqualTo(root.get("estimatedAgeDegreeDays"), estimatedAgeDegreeDaysGte)
                : null);
    }

    private Specification<SelectsGradingMale> estimatedAgeDegreeDaysLteSpec() {
        return ((root, query, cb) -> estimatedAgeDegreeDaysLte != null
                ? cb.lessThanOrEqualTo(root.get("estimatedAgeDegreeDays"), estimatedAgeDegreeDaysLte)
                : null);
    }

    private Specification<SelectsGradingMale> absoluteLengthGteSpec() {
        return ((root, query, cb) -> absoluteLengthGte != null
                ? cb.greaterThanOrEqualTo(root.get("absoluteLength"), absoluteLengthGte)
                : null);
    }

    private Specification<SelectsGradingMale> absoluteLengthLteSpec() {
        return ((root, query, cb) -> absoluteLengthLte != null
                ? cb.lessThanOrEqualTo(root.get("absoluteLength"), absoluteLengthLte)
                : null);
    }

    private Specification<SelectsGradingMale> bodyLengthBeforeEndScaleCoverGteSpec() {
        return ((root, query, cb) -> bodyLengthBeforeEndScaleCoverGte != null
                ? cb.greaterThanOrEqualTo(root.get("bodyLengthBeforeEndScaleCover"), bodyLengthBeforeEndScaleCoverGte)
                : null);
    }

    private Specification<SelectsGradingMale> bodyLengthBeforeEndScaleCoverLteSpec() {
        return ((root, query, cb) -> bodyLengthBeforeEndScaleCoverLte != null
                ? cb.lessThanOrEqualTo(root.get("bodyLengthBeforeEndScaleCover"), bodyLengthBeforeEndScaleCoverLte)
                : null);
    }

    private Specification<SelectsGradingMale> bodyLengthGteSpec() {
        return ((root, query, cb) -> bodyLengthGte != null
                ? cb.greaterThanOrEqualTo(root.get("bodyLength"), bodyLengthGte)
                : null);
    }

    private Specification<SelectsGradingMale> bodyLengthLteSpec() {
        return ((root, query, cb) -> bodyLengthLte != null
                ? cb.lessThanOrEqualTo(root.get("bodyLength"), bodyLengthLte)
                : null);
    }

    private Specification<SelectsGradingMale> headLengthGteSpec() {
        return ((root, query, cb) -> headLengthGte != null
                ? cb.greaterThanOrEqualTo(root.get("headLength"), headLengthGte)
                : null);
    }

    private Specification<SelectsGradingMale> headLengthLteSpec() {
        return ((root, query, cb) -> headLengthLte != null
                ? cb.lessThanOrEqualTo(root.get("headLength"), headLengthLte)
                : null);
    }

    private Specification<SelectsGradingMale> bodyHeightGteSpec() {
        return ((root, query, cb) -> bodyHeightGte != null
                ? cb.greaterThanOrEqualTo(root.get("bodyHeight"), bodyHeightGte)
                : null);
    }

    private Specification<SelectsGradingMale> bodyHeightLteSpec() {
        return ((root, query, cb) -> bodyHeightLte != null
                ? cb.lessThanOrEqualTo(root.get("bodyHeight"), bodyHeightLte)
                : null);
    }

    private Specification<SelectsGradingMale> backThicknessGteSpec() {
        return ((root, query, cb) -> backThicknessGte != null
                ? cb.greaterThanOrEqualTo(root.get("backThickness"), backThicknessGte)
                : null);
    }

    private Specification<SelectsGradingMale> backThicknessLteSpec() {
        return ((root, query, cb) -> backThicknessLte != null
                ? cb.lessThanOrEqualTo(root.get("backThickness"), backThicknessLte)
                : null);
    }

    private Specification<SelectsGradingMale> fatnessIndexGteSpec() {
        return ((root, query, cb) -> fatnessIndexGte != null
                ? cb.greaterThanOrEqualTo(root.get("fatnessIndex"), fatnessIndexGte)
                : null);
    }

    private Specification<SelectsGradingMale> fatnessIndexLteSpec() {
        return ((root, query, cb) -> fatnessIndexLte != null
                ? cb.lessThanOrEqualTo(root.get("fatnessIndex"), fatnessIndexLte)
                : null);
    }

    private Specification<SelectsGradingMale> headIndexGteSpec() {
        return ((root, query, cb) -> headIndexGte != null
                ? cb.greaterThanOrEqualTo(root.get("headIndex"), headIndexGte)
                : null);
    }

    private Specification<SelectsGradingMale> headIndexLteSpec() {
        return ((root, query, cb) -> headIndexLte != null
                ? cb.lessThanOrEqualTo(root.get("headIndex"), headIndexLte)
                : null);
    }

    private Specification<SelectsGradingMale> thicknessIndexGteSpec() {
        return ((root, query, cb) -> thicknessIndexGte != null
                ? cb.greaterThanOrEqualTo(root.get("thicknessIndex"), thicknessIndexGte)
                : null);
    }

    private Specification<SelectsGradingMale> thicknessIndexLteSpec() {
        return ((root, query, cb) -> thicknessIndexLte != null
                ? cb.lessThanOrEqualTo(root.get("thicknessIndex"), thicknessIndexLte)
                : null);
    }

    private Specification<SelectsGradingMale> indexRunnabilityGteSpec() {
        return ((root, query, cb) -> indexRunnabilityGte != null
                ? cb.greaterThanOrEqualTo(root.get("indexRunnability"), indexRunnabilityGte)
                : null);
    }

    private Specification<SelectsGradingMale> indexRunnabilityLteSpec() {
        return ((root, query, cb) -> indexRunnabilityLte != null
                ? cb.lessThanOrEqualTo(root.get("indexRunnability"), indexRunnabilityLte)
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

    private Specification<SelectsGradingMale> spermatocritValueGteSpec() {
        return ((root, query, cb) -> spermatocritValueGte != null
                ? cb.greaterThanOrEqualTo(root.get("spermatocritValue"), spermatocritValueGte)
                : null);
    }

    private Specification<SelectsGradingMale> spermatocritValueLteSpec() {
        return ((root, query, cb) -> spermatocritValueLte != null
                ? cb.lessThanOrEqualTo(root.get("spermatocritValue"), spermatocritValueLte)
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