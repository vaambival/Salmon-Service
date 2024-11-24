package com.vav.salmon_service.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.vav.salmon_service.dto.GetListResponse;
import com.vav.salmon_service.dto.CreateResponse;
import com.vav.salmon_service.dto.SelectsGradingDto;
import com.vav.salmon_service.service.SelectsGradingService;
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
public class SelectsGradingController {

    private final SelectsGradingService selectsGradingService;

    @GetMapping
    public GetListResponse getList(@ModelAttribute SelectsGradingFilter filter, Pageable pageable) {
        GetListResponse getListResponse = selectsGradingService.getList(filter, pageable);
        return getListResponse;
    }

    @GetMapping("/{id}")
    public SelectsGradingDto getOne(@PathVariable Long id) {
        return selectsGradingService.getOne(id);
    }

    @GetMapping("/by-ids")
    public List<SelectsGradingDto> getMany(@RequestParam List<Long> ids) {
        return selectsGradingService.getMany(ids);
    }

    @PostMapping
    public CreateResponse create(@RequestBody SelectsGradingDto dto) {
        return selectsGradingService.create(dto);
    }

    @PatchMapping("/{id}")
    public SelectsGradingDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        return selectsGradingService.patch(id, patchNode);
    }

    @PatchMapping
    public List<Long> patchMany(@RequestParam List<Long> ids, @RequestBody JsonNode patchNode) throws IOException {
        return selectsGradingService.patchMany(ids, patchNode);
    }

    @DeleteMapping("/{id}")
    public SelectsGradingDto delete(@PathVariable Long id) {
        return selectsGradingService.delete(id);
    }

    @DeleteMapping
    public void deleteMany(@RequestParam List<Long> ids) {
        selectsGradingService.deleteMany(ids);
    }
}
