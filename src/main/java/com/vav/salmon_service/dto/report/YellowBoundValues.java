package com.vav.salmon_service.dto.report;

import com.vav.salmon_service.entity.SelectsGrading;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.vav.salmon_service.entity.SelectsGrading.Fields.*;

@Getter
public class YellowBoundValues {
    private MinimumReport minimumBounds;
    private MaximumReport maximumBounds;
    private List<EliteFishReport> fishCharacteristics = new ArrayList<>();

    public YellowBoundValues(AverageReport averageReport, SigmaReport sigmaReport, List<SelectsGrading> salmons) {
        minimumBounds = new MinimumReport(averageReport, sigmaReport);
        maximumBounds = new MaximumReport(averageReport, sigmaReport);

        salmons.forEach(salmon -> {
            fillIfBetween(salmon.getId(), weight, salmon.getWeight(), minimumBounds.weight, maximumBounds.weight);
            fillIfBetween(salmon.getId(), lengthBody, salmon.getLengthBody(), minimumBounds.lengthBody, maximumBounds.lengthBody);
            fillIfBetween(salmon.getId(), heightBody, salmon.getHeightBody(), minimumBounds.heightBody, maximumBounds.heightBody);
            fillIfBetween(salmon.getId(), thicknessOfBack, salmon.getThicknessOfBack(), minimumBounds.thicknessOfBack, maximumBounds.thicknessOfBack);
            fillIfBetween(salmon.getId(), weightOfEggs, salmon.getWeightOfEggs(), minimumBounds.weightOfEggs, maximumBounds.weightOfEggs);
            fillIfBetween(salmon.getId(), weightOfSingleEgg, salmon.getWeightOfSingleEgg(), minimumBounds.weightOfSingleEgg, maximumBounds.weightOfSingleEgg);
            fillIfBetween(salmon.getId(), fatnessFactor, salmon.getFatnessFactor(), minimumBounds.fatnessFactor, maximumBounds.fatnessFactor);
            fillIfBetween(salmon.getId(), thickFactor, salmon.getThickFactor(), minimumBounds.thickFactor, maximumBounds.thickFactor);
            fillIfBetween(salmon.getId(), runnabilityIndex, salmon.getRunnabilityIndex(), minimumBounds.runnabilityIndex, maximumBounds.runnabilityIndex);
            fillIfBetween(salmon.getId(), headFactor, salmon.getHeadFactor(), minimumBounds.headFactor, maximumBounds.headFactor);
            fillIfBetween(salmon.getId(), caviarProportion, salmon.getCaviarProportion(), minimumBounds.caviarProportion, maximumBounds.caviarProportion);
            fillIfBetween(salmon.getId(), workingFertility, salmon.getWorkingFertility(), minimumBounds.workingFertility, maximumBounds.workingFertility);
            fillIfBetween(salmon.getId(), relativeFecundity, salmon.getRelativeFecundity(), minimumBounds.relativeFecundity, maximumBounds.relativeFecundity);
            fillIfBetween(salmon.getId(), reproductiveIndex, salmon.getReproductiveIndex(), minimumBounds.reproductiveIndex, maximumBounds.reproductiveIndex);
            fillIfBetween(salmon.getId(), percentOfDeathToThePeephole, salmon.getPercentOfDeathToThePeephole(), minimumBounds.percentOfDeathToThePeephole, maximumBounds.percentOfDeathToThePeephole);
            fillIfBetween(salmon.getId(), percentOfDeathAfterThePeephole, salmon.getPercentOfDeathAfterThePeephole(), minimumBounds.percentOfDeathAfterThePeephole, maximumBounds.percentOfDeathAfterThePeephole);
            fillIfBetween(salmon.getId(), percentOfEggFertilization, salmon.getPercentOfEggFertilization(), minimumBounds.percentOfEggFertilization, maximumBounds.percentOfEggFertilization);
            fillIfBetween(salmon.getId(), percentOfEmbryoSurvival, salmon.getPercentOfEmbryoSurvival(), minimumBounds.percentOfEmbryoSurvival, maximumBounds.percentOfEmbryoSurvival);
        });
    }

    private void fillIfBetween(Long id, String fieldName, Number val, double min, double max) {
        if (val == null) {
            return;
        }
        double dVal = val.doubleValue();
        if (dVal >= min && dVal < max) {
            fishCharacteristics.add(new EliteFishReport(String.valueOf(id), fieldName, dVal));
        }
    }
}
