package com.vav.salmon_service.dto.report;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class LostValues {
    //Идентификатор рыбы:пропущенные значения
    private Map<String, List<String>> lostValues;

    public void add(String fieldName, String id) {
        if (lostValues == null) {
            lostValues = new HashMap<>();
        }
        lostValues.computeIfAbsent(fieldName, k -> new ArrayList<>());
        lostValues.get(fieldName).add(id);
    }
}
