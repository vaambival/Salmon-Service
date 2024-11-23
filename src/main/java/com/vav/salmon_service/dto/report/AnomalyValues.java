package com.vav.salmon_service.dto.report;

import lombok.Getter;

import java.util.Map;

@Getter
public class AnomalyValues {
    Map<String, Map<String, Number>> anomalys;
}
