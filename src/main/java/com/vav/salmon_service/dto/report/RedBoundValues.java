package com.vav.salmon_service.dto.report;

import com.vav.salmon_service.entity.SelectsGrading;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.vav.salmon_service.entity.SelectsGrading.Fields.caviarProportion;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.fatnessFactor;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.headFactor;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.heightBody;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.lengthBody;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.percentOfDeathAfterThePeephole;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.percentOfDeathToThePeephole;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.percentOfEggFertilization;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.percentOfEmbryoSurvival;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.relativeFecundity;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.reproductiveIndex;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.runnabilityIndex;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.thickFactor;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.thicknessOfBack;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.weight;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.weightOfEggs;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.weightOfSingleEgg;
import static com.vav.salmon_service.entity.SelectsGrading.Fields.workingFertility;

@Getter
public class RedBoundValues {
    private MaximumReport minimumBounds;
    private List<EliteFishReport> fishCharacteristics = new ArrayList<>();

    public RedBoundValues(AverageReport averageReport, SigmaReport sigmaReport, List<SelectsGrading> salmons) {
        minimumBounds = new MaximumReport(averageReport, sigmaReport);

        salmons.forEach(salmon -> {
            fillIfGreaterOrEqual(salmon.getId(), weight, Double.valueOf(salmon.getWeight()), minimumBounds.weight);
            fillIfGreaterOrEqual(salmon.getId(), lengthBody, Double.valueOf(salmon.getLengthBody()), minimumBounds.lengthBody);
            fillIfGreaterOrEqual(salmon.getId(), heightBody, Double.valueOf(salmon.getHeightBody()), minimumBounds.heightBody);
            fillIfGreaterOrEqual(salmon.getId(), thicknessOfBack, Double.valueOf(salmon.getThicknessOfBack()), minimumBounds.thicknessOfBack);
            fillIfGreaterOrEqual(salmon.getId(), weightOfEggs, Double.valueOf(salmon.getWeightOfEggs()), minimumBounds.weightOfEggs);
            fillIfGreaterOrEqual(salmon.getId(), weightOfSingleEgg, Double.valueOf(salmon.getWeightOfSingleEgg()), minimumBounds.weightOfSingleEgg);
            fillIfGreaterOrEqual(salmon.getId(), fatnessFactor, salmon.getFatnessFactor(), minimumBounds.fatnessFactor);
            fillIfGreaterOrEqual(salmon.getId(), thickFactor, salmon.getThickFactor(), minimumBounds.thickFactor);
            fillIfGreaterOrEqual(salmon.getId(), runnabilityIndex, salmon.getRunnabilityIndex(), minimumBounds.runnabilityIndex);
            fillIfGreaterOrEqual(salmon.getId(), headFactor, salmon.getHeadFactor(), minimumBounds.headFactor);
            fillIfGreaterOrEqual(salmon.getId(), caviarProportion, salmon.getCaviarProportion(), minimumBounds.caviarProportion);
            fillIfGreaterOrEqual(salmon.getId(), workingFertility, salmon.getWorkingFertility(), minimumBounds.workingFertility);
            fillIfGreaterOrEqual(salmon.getId(), relativeFecundity, salmon.getRelativeFecundity(), minimumBounds.relativeFecundity);
            fillIfGreaterOrEqual(salmon.getId(), reproductiveIndex, salmon.getReproductiveIndex(), minimumBounds.reproductiveIndex);
            fillIfGreaterOrEqual(salmon.getId(), percentOfDeathToThePeephole, Double.valueOf(salmon.getPercentOfDeathToThePeephole()), minimumBounds.percentOfDeathToThePeephole);
            fillIfGreaterOrEqual(salmon.getId(), percentOfDeathAfterThePeephole, Double.valueOf(salmon.getPercentOfDeathAfterThePeephole()), minimumBounds.percentOfDeathAfterThePeephole);
            fillIfGreaterOrEqual(salmon.getId(), percentOfEggFertilization, Double.valueOf(salmon.getPercentOfEggFertilization()), minimumBounds.percentOfEggFertilization);
            fillIfGreaterOrEqual(salmon.getId(), percentOfEmbryoSurvival, Double.valueOf(salmon.getPercentOfEmbryoSurvival()), minimumBounds.percentOfEmbryoSurvival);
        });
    }

    private void fillIfGreaterOrEqual(Long id, String fieldName, Double val, double min) {
        if (val != null && val >= min) {
            fishCharacteristics.add(new EliteFishReport(String.valueOf(id), fieldName, val));
        }
    }
}
