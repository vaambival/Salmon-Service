package com.vav.salmon_service.repository;

import com.vav.salmon_service.entity.FishStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishStatisticRepository extends JpaRepository<FishStatistic, String> {
}