package com.vav.salmon_service.dto.report;

import java.util.List;

public record StatisticsReport(List<Message> report) {

    public record Message(String fieldName, SEVERITY severity, String message, Double bound, double value) { }

    public enum SEVERITY {
        INFO,
        WARNING,
        CRITICAL_WARNING,
        ERROR
    }
}
