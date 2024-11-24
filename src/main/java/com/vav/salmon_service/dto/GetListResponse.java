package com.vav.salmon_service.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetListResponse {
    PagedModel<SelectsGradingDto> content;
    List<Diapason> diapasons = new ArrayList<>();

    public GetListResponse(Page<SelectsGradingDto> selectGradings) {
        this.content = new PagedModel<>(selectGradings);
    }


    @Getter
    public static class Diapason {
        String fieldName;
        double yellowBound;
        double redBound;
    }
}
