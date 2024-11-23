package com.vav.salmon_service.dto.report;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ReportRecord {
    double weight;
    double lengthBody;
    double heightBody;
    double thicknessOfBack;
    double weightOfEggs;
    double weightOfSingleEgg;
    double fatnessFactor;
    double thickFactor;
    double runnabilityIndex;
    double headFactor;
    double caviarProportion;
    double workingFertility;
    double relativeFecundity;
    double reproductiveIndex;
    double percentOfDeathToThePeephole;
    double percentOfDeathAfterThePeephole;
    double percentOfEggFertilization;
    double percentOfEmbryoSurvival;
}
