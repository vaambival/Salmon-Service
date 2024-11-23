package com.vav.salmon_service.rest;

import com.vav.salmon_service.common.Gender;
import com.vav.salmon_service.dto.report.GradeSalmonReport;
import com.vav.salmon_service.dto.report.ReportGenerator;
import com.vav.salmon_service.repository.SelectsGradingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final SelectsGradingRepository repository;
    private final ReportGenerator reportGenerator;

    @GetMapping("/grade")
    public GradeSalmonReport getGradeSalmonReportByDateAndGender(
            @RequestParam(value = "created_after", required = false) LocalDateTime createdAfter,
            @RequestParam(value = "created_before", required = false) LocalDateTime createdBefore,
            @RequestParam(value = "gender", required = false) Gender gender) {
        var salmons = repository
                .findAll(new GradingReportFilter(createdAfter, createdBefore, gender).toSpecification());
        return reportGenerator.gradeSalmonReport(salmons);
    }
}
