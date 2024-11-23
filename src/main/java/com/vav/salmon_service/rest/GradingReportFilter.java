package com.vav.salmon_service.rest;

import com.vav.salmon_service.common.Gender;
import com.vav.salmon_service.entity.SelectsGrading;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public record GradingReportFilter(LocalDateTime startDateTime, LocalDateTime endDateTime, Gender gender) {

    public Specification<SelectsGrading> toSpecification() {
        return Specification.where(createdGteSpec())
                .and(createdLteSpec())
                .and(genderEqSpec());
    }

    private Specification<SelectsGrading> genderEqSpec() {
        return (root, query, criteriaBuilder) -> gender == null || gender == Gender.ANY ? null :
                criteriaBuilder.equal(root.get("gender"), gender);
    }

    private Specification<SelectsGrading> createdGteSpec() {
        return (root, query, criteriaBuilder) -> startDateTime != null ?
                criteriaBuilder.greaterThanOrEqualTo(root.get("created"), startDateTime) : null;
    }

    private Specification<SelectsGrading> createdLteSpec() {
        return (root, query, criteriaBuilder) -> endDateTime != null ?
                criteriaBuilder.lessThanOrEqualTo(root.get("created"), endDateTime) : null;
    }
}
