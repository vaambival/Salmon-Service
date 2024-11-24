package com.vav.salmon_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vav.salmon_service.converter.SelectsGradingMapper;
import com.vav.salmon_service.dto.CreateResponse;
import com.vav.salmon_service.dto.SelectsGradingDto;
import com.vav.salmon_service.dto.report.StatisticsReport;
import com.vav.salmon_service.entity.FishStatistic;
import com.vav.salmon_service.entity.SelectsGrading;
import com.vav.salmon_service.repository.FishStatisticRepository;
import com.vav.salmon_service.repository.SelectsGradingRepository;
import com.vav.salmon_service.rest.SelectsGradingFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SelectsGradingService {

    private final SelectsGradingMapper selectsGradingMapper;

    private final SelectsGradingRepository selectsGradingRepository;

    private final FishStatisticRepository fishStatisticRepository;

    private final ObjectMapper objectMapper;

    public Page<SelectsGradingDto> getList(SelectsGradingFilter filter, Pageable pageable) {
        Specification<SelectsGrading> spec = filter.toSpecification();
        Page<SelectsGrading> selectsGradingMales = selectsGradingRepository.findAll(spec, pageable);
        return selectsGradingMales.map(selectsGradingMapper::toDto);
    }

    public SelectsGradingDto getOne(Long id) {
        Optional<SelectsGrading> selectsGradingMaleOptional = selectsGradingRepository.findById(id);
        return selectsGradingMapper.toDto(selectsGradingMaleOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<SelectsGradingDto> getMany(List<Long> ids) {
        List<SelectsGrading> selectsGradings = selectsGradingRepository.findAllById(ids);
        return selectsGradings.stream()
                .map(selectsGradingMapper::toDto)
                .toList();
    }

    public CreateResponse create(SelectsGradingDto dto) {
        SelectsGrading selectsGrading = selectsGradingMapper.toEntity(dto);
        selectsGrading.setCreated(LocalDateTime.now());
        var statisticsReport = validateAndUpdateStatistics(selectsGrading);
        SelectsGrading resultSelectsGrading = selectsGradingRepository.save(selectsGrading);
        var savedDto = selectsGradingMapper.toDto(resultSelectsGrading);
        return new CreateResponse(savedDto, statisticsReport);
    }

    private StatisticsReport validateAndUpdateStatistics(SelectsGrading selectsGrading) {
        //TODO:
        var statistics = fishStatisticRepository.findAll();
        var weightStatistic = statistics.stream()
                .filter(s -> s.getParamName().equals("weight"))
                .findFirst()
                .get();
        var weightStatisticMessage = getWeightMessage(weightStatistic, selectsGrading.getWeight());
        var listMessages = List.of(weightStatisticMessage);

        return new StatisticsReport(listMessages);
    }

    private StatisticsReport.Message getWeightMessage(FishStatistic weightStatistic, Integer weight) {
        var max = weightStatistic.getMaximum();
        var min = weightStatistic.getMinimum();
        var sigma = weightStatistic.getSigma();
        var warningMin = min - sigma;
        var criticalMin = min - 3 * sigma;
        var errorMin = min - 5 * sigma;
        var warningMax = max + sigma;
        var criticalMax = max + 3 * sigma;
        var errorMax = max + 5 * sigma;
        StatisticsReport.SEVERITY severity;
        double bound;
        String message;
        if (weight < min) {
            severity = StatisticsReport.SEVERITY.INFO;
            bound = min;
            message = "Меньше минимума";
            if (weight < errorMin ) {
                severity = StatisticsReport.SEVERITY.ERROR;
                bound = errorMin;
                message = "Меньше минимума не реально";
            } else if (weight < criticalMin) {
                severity = StatisticsReport.SEVERITY.CRITICAL_WARNING;
                bound = criticalMin;
                message = "Меньше минимума критически";
            } else if (weight < warningMin) {
                severity = StatisticsReport.SEVERITY.WARNING;
                bound = warningMin;
                message = "Меньше минимума вызывающе";
            }
            return new StatisticsReport.Message("weight", severity, message, bound, weight);

        } else if (weight > max) {

        }
        return null;
    }

    public SelectsGradingDto patch(Long id, JsonNode patchNode) throws IOException {
        SelectsGrading selectsGrading = selectsGradingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        SelectsGradingDto selectsGradingDto = selectsGradingMapper.toDto(selectsGrading);
        objectMapper.readerForUpdating(selectsGradingDto).readValue(patchNode);
        selectsGradingMapper.partialUpdate(selectsGradingDto, selectsGrading);

        SelectsGrading resultSelectsGrading = selectsGradingRepository.save(selectsGrading);
        return selectsGradingMapper.toDto(resultSelectsGrading);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<SelectsGrading> selectsGradings = selectsGradingRepository.findAllById(ids);

        for (SelectsGrading selectsGrading : selectsGradings) {
            SelectsGradingDto selectsGradingDto = selectsGradingMapper.toDto(selectsGrading);
            objectMapper.readerForUpdating(selectsGradingDto).readValue(patchNode);
            selectsGradingMapper.partialUpdate(selectsGradingDto, selectsGrading);
        }

        List<SelectsGrading> resultSelectsGradings = selectsGradingRepository.saveAll(selectsGradings);
        return resultSelectsGradings.stream()
                .map(SelectsGrading::getId)
                .toList();
    }

    public SelectsGradingDto delete(Long id) {
        SelectsGrading selectsGrading = selectsGradingRepository.findById(id).orElse(null);
        if (selectsGrading != null) {
            selectsGradingRepository.delete(selectsGrading);
        }
        return selectsGradingMapper.toDto(selectsGrading);
    }

    public void deleteMany(List<Long> ids) {
        selectsGradingRepository.deleteAllById(ids);
    }
}
