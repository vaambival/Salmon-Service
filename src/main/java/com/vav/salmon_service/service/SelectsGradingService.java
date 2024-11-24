package com.vav.salmon_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vav.salmon_service.converter.SelectsGradingMapper;
import com.vav.salmon_service.dto.CreateResponse;
import com.vav.salmon_service.dto.SelectsGradingDto;
import com.vav.salmon_service.dto.report.StatisticsReport;
import com.vav.salmon_service.entity.SelectsGrading;
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
