package com.vav.salmon_service.dto.report;

import lombok.Getter;

import java.util.Map;

@Getter
public class RedBoundValues {
    private MinimumReport minimumBounds;
    //Имя характеристики:идентификатор рыбы: значение
    Map<String, Map<String, Double>> fishCharacteristics;
}
