package com.vav.salmon_service.dto.report;

import lombok.Getter;

import java.util.Map;

@Getter
public class YellowBoundValues {
    private MinimumReport minimumBounds;
    private MaximumReport maximumBounds;
    //Имя характеристики:идентификатор рыбы: значение
    Map<String, Map<String, Double>> fishCharacteristics;
}
