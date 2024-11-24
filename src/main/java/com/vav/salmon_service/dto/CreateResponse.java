package com.vav.salmon_service.dto;

import com.vav.salmon_service.dto.report.StatisticsReport;

public record CreateResponse(SelectsGradingDto grade, StatisticsReport report) {
}
