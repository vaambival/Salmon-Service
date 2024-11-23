package com.vav.salmon_service.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.vav.salmon_service.dto.SelectsGradingMaleDto;
import com.vav.salmon_service.service.SelectsGradingMaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("trout/rest/selects_grading")
@RequiredArgsConstructor
public class SelectsGradingMaleController {

    private final SelectsGradingMaleService selectsGradingMaleService;

    @GetMapping
    public PagedModel<SelectsGradingMaleDto> getList(@ModelAttribute SelectsGradingMaleFilter filter, Pageable pageable) {
        Page<SelectsGradingMaleDto> selectsGradingMaleDtos = selectsGradingMaleService.getList(filter, pageable);
        return new PagedModel<>(selectsGradingMaleDtos);
    }

    @GetMapping("/{id}")
    public SelectsGradingMaleDto getOne(@PathVariable Long id) {
        return selectsGradingMaleService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<SelectsGradingMaleDto> getMany(@RequestParam List<Long> ids) {
        return selectsGradingMaleService.getMany(ids);
    }

    @PostMapping
    public SelectsGradingMaleDto create(@RequestBody SelectsGradingMaleDto dto) {
        return selectsGradingMaleService.create(dto);
    }

    @PatchMapping("/{id}")
    public SelectsGradingMaleDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return selectsGradingMaleService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return selectsGradingMaleService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public SelectsGradingMaleDto delete(@PathVariable Long id) {
        return selectsGradingMaleService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        selectsGradingMaleService.deleteMany(ids);
    }
}
