package com.vav.salmon_service.repository;

import com.vav.salmon_service.entity.SelectsGrading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectsGradingRepository extends JpaRepository<SelectsGrading, Long>, JpaSpecificationExecutor<SelectsGrading> {
}