package com.vav.salmon_service.dto.report;

import lombok.Getter;

import java.util.List;

@Getter
public class StatisticsReport {
    private List<Message> report;

    @Getter
    public static class Message {
        private SEVERITY severity;
        private String message;
        private double bound;
        private double value;
    }

    public static enum SEVERITY {
        INFO,
        WARNING,
        CRITICAL_WARNING,
        ERROR
    }
}
