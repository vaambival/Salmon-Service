package com.vav.salmon_service.repository;

import com.vav.salmon_service.entity.SelectsGradingMale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectsGradingMaleRepository extends JpaRepository<SelectsGradingMale, Long>, JpaSpecificationExecutor<SelectsGradingMale> {
}