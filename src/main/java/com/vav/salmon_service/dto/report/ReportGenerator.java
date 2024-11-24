package com.vav.salmon_service.dto.report;

import com.vav.salmon_service.entity.SelectsGrading;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

import static com.vav.salmon_service.entity.SelectsGrading.Fields.*;

@Component
public class ReportGenerator {

    public GradeSalmonReport gradeSalmonReport(List<SelectsGrading> salmons) {
        AverageReport average = new AverageReport();
        MaximumReport max = new MaximumReport();
        MinimumReport min = new MinimumReport();

        salmons.forEach(salmon -> {
            updateAverage(average, salmon);
            updateMax(max, salmon);
            updateMin(min, salmon);
        });
        LostValues lostValues = new LostValues();
        Map<String, Integer> averageCount = calculateAverageAndFindLostAndAnomalValues(average, salmons, lostValues);
        SigmaReport sigmaReport = new SigmaReport();
        calcSigmas(sigmaReport, average, salmons, averageCount);
        ErrorReport errorReport = new ErrorReport();
        calcErrorReport(averageCount, sigmaReport, errorReport);
        //Коэффициент вариации
        CvReport cvReport = new CvReport();
        calcCvReport(cvReport, sigmaReport, average);
        AnomalyValues anomalyValues = new AnomalyValues();
        YellowBoundValues yellowBoundValues = new YellowBoundValues(average, sigmaReport, salmons);
        RedBoundValues redBoundValues = new RedBoundValues(average, sigmaReport, salmons);
        return new GradeSalmonReport(average, max, min, sigmaReport, errorReport, cvReport, redBoundValues, yellowBoundValues, lostValues, anomalyValues);
    }

    private void calcCvReport(CvReport cvReport, SigmaReport sigmaReport, ReportRecord average) {
        cvReport.weight = cv(sigmaReport.weight, average.weight);
        cvReport.lengthBody = cv(sigmaReport.lengthBody, average.lengthBody);
        cvReport.heightBody = cv(sigmaReport.heightBody, average.heightBody);
        cvReport.thicknessOfBack = cv(sigmaReport.thicknessOfBack, average.thicknessOfBack);
        cvReport.weightOfEggs = cv(sigmaReport.weightOfEggs, average.weightOfEggs);
        cvReport.weightOfSingleEgg = cv(sigmaReport.weightOfSingleEgg, average.weightOfSingleEgg);
        cvReport.fatnessFactor = cv(sigmaReport.fatnessFactor, average.fatnessFactor);
        cvReport.thickFactor = cv(sigmaReport.thickFactor, average.thickFactor);
        cvReport.runnabilityIndex = cv(sigmaReport.runnabilityIndex, average.runnabilityIndex);
        cvReport.headFactor = cv(sigmaReport.headFactor, average.headFactor);
        cvReport.caviarProportion = cv(sigmaReport.caviarProportion, average.caviarProportion);
        cvReport.workingFertility = cv(sigmaReport.workingFertility, average.workingFertility);
        cvReport.relativeFecundity = cv(sigmaReport.relativeFecundity, average.relativeFecundity);
        cvReport.reproductiveIndex = cv(sigmaReport.reproductiveIndex, average.reproductiveIndex);
        cvReport.percentOfDeathToThePeephole = cv(sigmaReport.percentOfDeathToThePeephole, average.percentOfDeathToThePeephole);
        cvReport.percentOfDeathAfterThePeephole = cv(sigmaReport.percentOfDeathAfterThePeephole, average.percentOfDeathAfterThePeephole);
        cvReport.percentOfEggFertilization = cv(sigmaReport.percentOfEggFertilization, average.percentOfEggFertilization);
        cvReport.percentOfEmbryoSurvival = cv(sigmaReport.percentOfEmbryoSurvival, average.percentOfEmbryoSurvival);
    }

    private double cv(double sigma, double average) {
        return 100 * sigma / average;
    }

    private void calcErrorReport(Map<String, Integer> averageCount, SigmaReport sigmaReport, ErrorReport errorReport) {
        averageCount.forEach((k, v) -> {
            switch (k) {
                case weight -> errorReport.weight = sigmaReport.weight / Math.pow(v, .5);
                case lengthBody -> errorReport.lengthBody = sigmaReport.lengthBody / Math.pow(v, .5);
                case heightBody -> errorReport.heightBody = sigmaReport.heightBody / Math.pow(v, .5);
                case thicknessOfBack -> errorReport.thicknessOfBack = sigmaReport.thicknessOfBack / Math.pow(v, .5);
                case weightOfEggs -> errorReport.weightOfEggs = sigmaReport.weightOfEggs / Math.pow(v, .5);
                case weightOfSingleEgg -> errorReport.weightOfSingleEgg = sigmaReport.weightOfSingleEgg / Math.pow(v, .5);
                case fatnessFactor -> errorReport.fatnessFactor = sigmaReport.fatnessFactor / Math.pow(v, .5);
                case thickFactor -> errorReport.thickFactor = sigmaReport.thickFactor / Math.pow(v, .5);
                case runnabilityIndex -> errorReport.runnabilityIndex = sigmaReport.runnabilityIndex / Math.pow(v, .5);
                case headFactor -> errorReport.headFactor = sigmaReport.headFactor / Math.pow(v, .5);
                case caviarProportion -> errorReport.caviarProportion = sigmaReport.caviarProportion / Math.pow(v, .5);
                case workingFertility -> errorReport.workingFertility = sigmaReport.workingFertility / Math.pow(v, .5);
                case relativeFecundity -> errorReport.relativeFecundity = sigmaReport.relativeFecundity / Math.pow(v, .5);
                case reproductiveIndex -> errorReport.reproductiveIndex = sigmaReport.reproductiveIndex / Math.pow(v, .5);
                case percentOfDeathToThePeephole -> errorReport.percentOfDeathToThePeephole = sigmaReport.percentOfDeathToThePeephole / Math.pow(v, .5);
                case percentOfDeathAfterThePeephole -> errorReport.percentOfDeathAfterThePeephole = sigmaReport.percentOfDeathAfterThePeephole / Math.pow(v, .5);
                case percentOfEggFertilization -> errorReport.percentOfEggFertilization = sigmaReport.percentOfEggFertilization / Math.pow(v, .5);
                case percentOfEmbryoSurvival -> errorReport.percentOfEmbryoSurvival = sigmaReport.percentOfEmbryoSurvival / Math.pow(v, .5);
            }
        });
    }

    private void calcSigmas(SigmaReport sigmaReport, ReportRecord average, List<SelectsGrading> salmons,
                            Map<String, Integer> averageCount) {
        averageCount.forEach((k, v) -> {
            switch (k) {
                case weight -> sigmaReport.weight = sigma(average.weight, salmons.stream().map(SelectsGrading::getWeight)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case lengthBody -> sigmaReport.lengthBody = sigma(average.lengthBody, salmons.stream().map(SelectsGrading::getLengthBody)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case heightBody -> sigmaReport.heightBody = sigma(average.heightBody, salmons.stream().map(SelectsGrading::getHeightBody)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case thicknessOfBack -> sigmaReport.thicknessOfBack = sigma(average.thicknessOfBack, salmons.stream().map(SelectsGrading::getThicknessOfBack)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case weightOfEggs -> sigmaReport.weightOfEggs = sigma(average.weightOfEggs, salmons.stream().map(SelectsGrading::getWeightOfEggs)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case weightOfSingleEgg -> sigmaReport.weightOfSingleEgg = sigma(average.weightOfSingleEgg, salmons.stream().map(SelectsGrading::getWeightOfSingleEgg)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case fatnessFactor -> sigmaReport.fatnessFactor = sigma(average.fatnessFactor, salmons.stream().map(SelectsGrading::getFatnessFactor)
                        .filter(Objects::nonNull).toList(), v);
                case thickFactor -> sigmaReport.thickFactor = sigma(average.thickFactor, salmons.stream().map(SelectsGrading::getThickFactor)
                        .filter(Objects::nonNull).toList(), v);
                case runnabilityIndex -> sigmaReport.runnabilityIndex = sigma(average.runnabilityIndex, salmons.stream().map(SelectsGrading::getRunnabilityIndex)
                        .filter(Objects::nonNull).toList(), v);
                case headFactor -> sigmaReport.headFactor = sigma(average.headFactor, salmons.stream().map(SelectsGrading::getHeadFactor)
                        .filter(Objects::nonNull).toList(), v);
                case caviarProportion -> sigmaReport.caviarProportion = sigma(average.caviarProportion, salmons.stream().map(SelectsGrading::getCaviarProportion)
                        .filter(Objects::nonNull).toList(), v);
                case workingFertility -> sigmaReport.workingFertility = sigma(average.workingFertility, salmons.stream().map(SelectsGrading::getWorkingFertility)
                        .filter(Objects::nonNull).toList(), v);
                case relativeFecundity -> sigmaReport.relativeFecundity = sigma(average.relativeFecundity, salmons.stream().map(SelectsGrading::getRelativeFecundity)
                        .filter(Objects::nonNull).toList(), v);
                case reproductiveIndex -> sigmaReport.reproductiveIndex = sigma(average.reproductiveIndex, salmons.stream().map(SelectsGrading::getReproductiveIndex)
                        .filter(Objects::nonNull).toList(), v);
                case percentOfDeathToThePeephole -> sigmaReport.percentOfDeathToThePeephole = sigma(average.percentOfDeathToThePeephole, salmons.stream().map(SelectsGrading::getPercentOfDeathToThePeephole)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case percentOfDeathAfterThePeephole -> sigmaReport.percentOfDeathAfterThePeephole = sigma(average.percentOfDeathAfterThePeephole, salmons.stream().map(SelectsGrading::getPercentOfDeathAfterThePeephole)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case percentOfEggFertilization -> sigmaReport.percentOfEggFertilization = sigma(average.percentOfEggFertilization, salmons.stream().map(SelectsGrading::getPercentOfEggFertilization)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
                case percentOfEmbryoSurvival -> sigmaReport.percentOfEmbryoSurvival = sigma(average.percentOfEmbryoSurvival, salmons.stream().map(SelectsGrading::getPercentOfEmbryoSurvival)
                        .filter(Objects::nonNull).map(Double::valueOf).toList(), v);
            }
        });
    }

    private double sigma(double average, List<Double> values, Integer count) {
        double sum = values.stream()
                .mapToDouble(x -> (x - average) * (x - average))
                .sum();
        if (count == 1) {
            return 0.0;
        }
        return Math.pow(sum / (count - 1), 0.5);
    }

    private Map<String, Integer> calculateAverageAndFindLostAndAnomalValues(ReportRecord average, List<SelectsGrading> salmons,
                                                            LostValues lostValues) {
        Map<String, Integer> averageCount = new HashMap<>();
        salmons.forEach(salmon -> {
            incrementIfNotNull(weight, salmon.getWeight(), lostValues , averageCount, salmon.getId());
            incrementIfNotNull(lengthBody, salmon.getLengthBody(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(heightBody, salmon.getHeightBody(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(thicknessOfBack, salmon.getThicknessOfBack(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(weightOfEggs, salmon.getWeightOfEggs(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(weightOfSingleEgg, salmon.getWeightOfSingleEgg(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(fatnessFactor, salmon.getFatnessFactor(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(thickFactor, salmon.getThickFactor(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(runnabilityIndex, salmon.getRunnabilityIndex(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(headFactor, salmon.getHeadFactor(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(caviarProportion, salmon.getCaviarProportion(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(workingFertility, salmon.getWorkingFertility(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(relativeFecundity, salmon.getRelativeFecundity(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(reproductiveIndex, salmon.getReproductiveIndex(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(percentOfDeathToThePeephole, salmon.getPercentOfDeathToThePeephole(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(percentOfDeathAfterThePeephole, salmon.getPercentOfDeathAfterThePeephole(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(percentOfEggFertilization, salmon.getPercentOfEggFertilization(), lostValues, averageCount, salmon.getId());
            incrementIfNotNull(percentOfEmbryoSurvival, salmon.getPercentOfEmbryoSurvival(), lostValues, averageCount, salmon.getId());
        });
        updateAverage(average, averageCount);
        return averageCount;
    }

    private void updateAverage(ReportRecord average, Map<String, Integer> averageCount) {
        average.weight = calculateAverage(average.weight, averageCount.get(weight));
        average.lengthBody = calculateAverage(average.lengthBody, averageCount.get(lengthBody));
        average.heightBody = calculateAverage(average.heightBody, averageCount.get(heightBody));
        average.thicknessOfBack = calculateAverage(average.thicknessOfBack, averageCount.get(thicknessOfBack));
        average.weightOfEggs = calculateAverage(average.weightOfEggs, averageCount.get(weightOfEggs));
        average.weightOfSingleEgg = calculateAverage(average.weightOfSingleEgg, averageCount.get(weightOfSingleEgg));
        average.fatnessFactor = calculateAverage(average.fatnessFactor, averageCount.get(fatnessFactor));
        average.thickFactor = calculateAverage(average.thickFactor, averageCount.get(thickFactor));
        average.runnabilityIndex = calculateAverage(average.runnabilityIndex, averageCount.get(runnabilityIndex));
        average.headFactor = calculateAverage(average.headFactor, averageCount.get(headFactor));
        average.caviarProportion = calculateAverage(average.caviarProportion, averageCount.get(caviarProportion));
        average.workingFertility = calculateAverage(average.workingFertility, averageCount.get(workingFertility));
        average.relativeFecundity = calculateAverage(average.relativeFecundity, averageCount.get(relativeFecundity));
        average.reproductiveIndex = calculateAverage(average.reproductiveIndex, averageCount.get(reproductiveIndex));
        average.percentOfDeathToThePeephole = calculateAverage(average.percentOfDeathToThePeephole, averageCount.get(percentOfDeathToThePeephole));
        average.percentOfDeathAfterThePeephole = calculateAverage(average.percentOfDeathAfterThePeephole, averageCount.get(percentOfDeathAfterThePeephole));
        average.percentOfEggFertilization = calculateAverage(average.percentOfEggFertilization, averageCount.get(percentOfEggFertilization));
        average.percentOfEmbryoSurvival = calculateAverage(average.percentOfEmbryoSurvival, averageCount.get(percentOfEmbryoSurvival));
    }

    private double calculateAverage(double weight, Integer count) {
        if (count == null || count == 0) {
            return 0.0;
        }
        return weight / count;
    }

    private static void incrementIfNotNull(String fieldName, Object field, LostValues lostValues,
                                           Map<String, Integer> averageCount, Long id) {
        if (field == null) {
            lostValues.add(fieldName, String.valueOf(id));
        } else {
            averageCount.merge(fieldName, 1, Integer::sum);
        }
    }

    private void updateMin(ReportRecord min, SelectsGrading salmon) {
        updateWeight(min, salmon, Math::min);
        updateLengthBody(min, salmon, Math::min);
        updateHeightBody(min, salmon, Math::min);
        updateThicknessOfBack(min, salmon, Math::min);
        if (salmon.isFemale()) {
            updateWeightOfEggs(min, salmon, Math::min);
            updateWeightOfSingleEgg(min, salmon, Math::min);
            caviarProportion(min, salmon, Math::min);
            workingFertility(min, salmon, Math::min);
            relativeFecundity(min, salmon, Math::min);
            reproductiveIndex(min, salmon, Math::min);
            percentOfOfDeathToThePeephole(min, salmon, Math::min);
            percentOfOfDeathAfterThePeephole(min, salmon, Math::min);
            percentOfEggFertilization(min, salmon, Math::min);
            percentOfEmbryoSurvival(min, salmon, Math::min);
        }
        fatnessFactor(min, salmon, Math::max);
        thickFactor(min, salmon, Math::max);
        runnabilityIndex(min, salmon, Math::max);
        headFactor(min, salmon, Math::max);
    }

    private void updateMax(ReportRecord max, SelectsGrading salmon) {
        updateWeight(max, salmon, Math::max);
        updateLengthBody(max, salmon, Math::max);
        updateHeightBody(max, salmon, Math::max);
        updateThicknessOfBack(max, salmon, Math::max);
        if (salmon.isFemale()) {
            updateWeightOfEggs(max, salmon, Math::max);
            updateWeightOfSingleEgg(max, salmon, Math::max);
            caviarProportion(max, salmon, Math::max);
            workingFertility(max, salmon, Math::max);
            relativeFecundity(max, salmon, Math::max);
            reproductiveIndex(max, salmon, Math::max);
            percentOfOfDeathToThePeephole(max, salmon, Math::max);
            percentOfOfDeathAfterThePeephole(max, salmon, Math::max);
            percentOfEggFertilization(max, salmon, Math::max);
            percentOfEmbryoSurvival(max, salmon, Math::max);
        }
        fatnessFactor(max, salmon, Math::max);
        thickFactor(max, salmon, Math::max);
        runnabilityIndex(max, salmon, Math::max);
        headFactor(max, salmon, Math::max);
    }

    private void updateAverage(ReportRecord average, SelectsGrading salmon) {
        updateWeight(average, salmon, Double::sum);
        updateLengthBody(average, salmon, Double::sum);
        updateHeightBody(average, salmon, Double::sum);
        updateThicknessOfBack(average, salmon, Double::sum);
        if (salmon.isFemale()) {
            updateWeightOfEggs(average, salmon, Double::sum);
            updateWeightOfSingleEgg(average, salmon, Double::sum);
            caviarProportion(average, salmon, Double::sum);
            workingFertility(average, salmon, Double::sum);
            relativeFecundity(average, salmon, Double::sum);
            reproductiveIndex(average, salmon, Double::sum);
            percentOfOfDeathToThePeephole(average, salmon, Double::sum);
            percentOfOfDeathAfterThePeephole(average, salmon, Double::sum);
            percentOfEggFertilization(average, salmon, Double::sum);
            percentOfEmbryoSurvival(average, salmon, Double::sum);
        }
        fatnessFactor(average, salmon, Double::sum);
        thickFactor(average, salmon, Double::sum);
        runnabilityIndex(average, salmon, Double::sum);
        headFactor(average, salmon, Double::sum);
    }

    private void headFactor(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getHeadFactor() != null) {
            average.headFactor = func.apply(average.headFactor, salmon.getHeadFactor());
        }
    }

    private void runnabilityIndex(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getRunnabilityIndex() != null) {
            average.runnabilityIndex = func.apply(average.getRunnabilityIndex(), salmon.getRunnabilityIndex());
        }
    }

    private void thickFactor(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getThickFactor() != null) {
            average.thickFactor = func.apply(average.getThickFactor(), salmon.getThickFactor());
        }
    }

    private void fatnessFactor(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getFatnessFactor() != null) {
            average.fatnessFactor = func.apply(average.fatnessFactor, salmon.getFatnessFactor());
        }
    }

    private void percentOfEmbryoSurvival(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getPercentOfEmbryoSurvival() != null) {
            average.percentOfEmbryoSurvival = func.apply(average.percentOfEmbryoSurvival, Double.valueOf(salmon.getPercentOfEmbryoSurvival()));
        }
    }

    private void percentOfEggFertilization(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getPercentOfEggFertilization() != null) {
            average.percentOfEggFertilization = func.apply(average.percentOfEggFertilization, Double.valueOf(salmon.getPercentOfEggFertilization()));
        }
    }

    private void percentOfOfDeathAfterThePeephole(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getPercentOfDeathAfterThePeephole() != null) {
            average.percentOfDeathAfterThePeephole = func.apply(average.percentOfDeathAfterThePeephole, Double.valueOf(salmon.getPercentOfDeathAfterThePeephole()));
        }
    }

    private void percentOfOfDeathToThePeephole(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getPercentOfDeathToThePeephole() != null) {
            average.percentOfDeathToThePeephole = func.apply(average.percentOfDeathToThePeephole, Double.valueOf(salmon.getPercentOfDeathToThePeephole()));
        }
    }

    private void relativeFecundity(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getRelativeFecundity() != null) {
            average.relativeFecundity = func.apply(average.relativeFecundity, salmon.getRelativeFecundity());
        }
    }

    private void reproductiveIndex(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getReproductiveIndex() != null) {
            average.reproductiveIndex = func.apply(average.reproductiveIndex, salmon.getReproductiveIndex());
        }
    }

    private void workingFertility(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getWorkingFertility() != null) {
            average.workingFertility = func.apply(average.workingFertility, salmon.getWorkingFertility());
        }
    }

    private void caviarProportion(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getCaviarProportion() != null) {
            average.caviarProportion = func.apply(average.caviarProportion, salmon.getCaviarProportion());
        }
    }

    private void updateWeightOfSingleEgg(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getWeightOfSingleEgg() != null) {
            average.weightOfSingleEgg = func.apply(average.weightOfSingleEgg, Double.valueOf(salmon.getWeightOfSingleEgg()));
        }
    }

    private void updateWeightOfEggs(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getWeightOfEggs() != null) {
            average.weightOfEggs = func.apply(average.weightOfEggs, Double.valueOf(salmon.getWeightOfEggs()));
        }
    }

    private void updateThicknessOfBack(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getThicknessOfBack() != null) {
            average.thicknessOfBack = func.apply(average.thicknessOfBack, Double.valueOf(salmon.getThicknessOfBack()));
        }
    }

    private void updateHeightBody(ReportRecord average, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getHeightBody() != null) {
            average.heightBody = func.apply(average.heightBody, Double.valueOf(salmon.getHeightBody()));
        }
    }

    private void updateLengthBody(ReportRecord record, SelectsGrading salmon,
                                  BiFunction<Double, Double, Double> func) {
        if (salmon.getLengthBody() != null) {
            record.lengthBody = func.apply(record.lengthBody, Double.valueOf(salmon.getLengthBody()));
        }
    }

    private void updateWeight(ReportRecord record, SelectsGrading salmon, BiFunction<Double, Double, Double> func) {
        if (salmon.getWeight() != null) {
            record.weight = func.apply(record.weight, Double.valueOf(salmon.getWeight()));
        }
    }
}
