package com.vav.salmon_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vav.salmon_service.converter.SelectsGradingMaleMapper;
import com.vav.salmon_service.dto.SelectsGradingMaleDto;
import com.vav.salmon_service.entity.SelectsGradingMale;
import com.vav.salmon_service.repository.SelectsGradingMaleRepository;
import com.vav.salmon_service.rest.SelectsGradingMaleFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SelectsGradingMaleService {

    private final SelectsGradingMaleMapper selectsGradingMaleMapper;

    private final SelectsGradingMaleRepository selectsGradingMaleRepository;

    private final ObjectMapper objectMapper;

    public Page<SelectsGradingMaleDto> getList(SelectsGradingMaleFilter filter, Pageable pageable) {
        Specification<SelectsGradingMale> spec = filter.toSpecification();
        Page<SelectsGradingMale> selectsGradingMales = selectsGradingMaleRepository.findAll(spec, pageable);
        return selectsGradingMales.map(selectsGradingMaleMapper::toDto);
    }

    public SelectsGradingMaleDto getOne(Long id) {
        Optional<SelectsGradingMale> selectsGradingMaleOptional = selectsGradingMaleRepository.findById(id);
        return selectsGradingMaleMapper.toDto(selectsGradingMaleOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<SelectsGradingMaleDto> getMany(List<Long> ids) {
        List<SelectsGradingMale> selectsGradingMales = selectsGradingMaleRepository.findAllById(ids);
        return selectsGradingMales.stream()
                .map(selectsGradingMaleMapper::toDto)
                .toList();
    }

    public SelectsGradingMaleDto create(SelectsGradingMaleDto dto) {
        SelectsGradingMale selectsGradingMale = selectsGradingMaleMapper.toEntity(dto);
        SelectsGradingMale resultSelectsGradingMale = selectsGradingMaleRepository.save(selectsGradingMale);
        return selectsGradingMaleMapper.toDto(resultSelectsGradingMale);
    }

    public SelectsGradingMaleDto patch(Long id, JsonNode patchNode) throws IOException {
        SelectsGradingMale selectsGradingMale = selectsGradingMaleRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        SelectsGradingMaleDto selectsGradingMaleDto = selectsGradingMaleMapper.toDto(selectsGradingMale);
        objectMapper.readerForUpdating(selectsGradingMaleDto).readValue(patchNode);
        selectsGradingMaleMapper.partialUpdate(selectsGradingMaleDto, selectsGradingMale);

        SelectsGradingMale resultSelectsGradingMale = selectsGradingMaleRepository.save(selectsGradingMale);
        return selectsGradingMaleMapper.toDto(resultSelectsGradingMale);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<SelectsGradingMale> selectsGradingMales = selectsGradingMaleRepository.findAllById(ids);

        for (SelectsGradingMale selectsGradingMale : selectsGradingMales) {
            SelectsGradingMaleDto selectsGradingMaleDto = selectsGradingMaleMapper.toDto(selectsGradingMale);
            objectMapper.readerForUpdating(selectsGradingMaleDto).readValue(patchNode);
            selectsGradingMaleMapper.partialUpdate(selectsGradingMaleDto, selectsGradingMale);
        }

        List<SelectsGradingMale> resultSelectsGradingMales = selectsGradingMaleRepository.saveAll(selectsGradingMales);
        return resultSelectsGradingMales.stream()
                .map(SelectsGradingMale::getId)
                .toList();
    }

    public SelectsGradingMaleDto delete(Long id) {
        SelectsGradingMale selectsGradingMale = selectsGradingMaleRepository.findById(id).orElse(null);
        if (selectsGradingMale != null) {
            selectsGradingMaleRepository.delete(selectsGradingMale);
        }
        return selectsGradingMaleMapper.toDto(selectsGradingMale);
    }

    public void deleteMany(List<Long> ids) {
        selectsGradingMaleRepository.deleteAllById(ids);
    }
}
