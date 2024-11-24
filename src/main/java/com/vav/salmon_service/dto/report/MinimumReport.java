package com.vav.salmon_service.dto.report;

public class MinimumReport extends ReportRecord {

    public MinimumReport() {}

    public MinimumReport(AverageReport averageReport, SigmaReport sigmaReport) {
        this.weight = averageReport.weight - sigmaReport.weight;
        this.lengthBody = averageReport.lengthBody - sigmaReport.lengthBody;
        this.heightBody = averageReport.heightBody - sigmaReport.heightBody;
        this.thicknessOfBack = averageReport.thicknessOfBack - sigmaReport.thicknessOfBack;
        this.weightOfEggs = averageReport.weightOfEggs - sigmaReport.weightOfEggs;
        this.weightOfSingleEgg = averageReport.weightOfSingleEgg - sigmaReport.weightOfSingleEgg;
        this.fatnessFactor = averageReport.fatnessFactor - sigmaReport.fatnessFactor;
        this.thickFactor = averageReport.thickFactor - sigmaReport.thickFactor;
        this.runnabilityIndex = averageReport.runnabilityIndex - sigmaReport.runnabilityIndex;
        this.headFactor = averageReport.headFactor - sigmaReport.headFactor;
        this.caviarProportion = averageReport.caviarProportion - sigmaReport.caviarProportion;
        this.workingFertility = averageReport.workingFertility - sigmaReport.workingFertility;
        this.relativeFecundity = averageReport.relativeFecundity - sigmaReport.relativeFecundity;
        this.reproductiveIndex = averageReport.reproductiveIndex - sigmaReport.reproductiveIndex;
        this.percentOfDeathToThePeephole = averageReport.percentOfDeathToThePeephole - sigmaReport.percentOfDeathToThePeephole;
        this.percentOfDeathAfterThePeephole = averageReport.percentOfDeathAfterThePeephole - sigmaReport.percentOfDeathAfterThePeephole;
        this.percentOfEggFertilization = averageReport.percentOfEggFertilization - sigmaReport.percentOfEggFertilization;
        this.percentOfEmbryoSurvival = averageReport.percentOfEmbryoSurvival - sigmaReport.percentOfEmbryoSurvival;
    }
}
