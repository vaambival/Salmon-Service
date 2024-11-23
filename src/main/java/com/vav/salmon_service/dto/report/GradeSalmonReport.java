package com.vav.salmon_service.dto.report;

public record GradeSalmonReport(AverageReport averageReport, MaximumReport maximumReport, MinimumReport minimumReport,
                                SigmaReport sigmaReport, ErrorReport errorReport, CvReport cvReport,
                                RedBoundValues redBoundValues, YellowBoundValues yellowBoundValues,
                                LostValues lostValues, AnomalyValues anomalyValues) {
}
