package com.vav.salmon_service.dto;

import com.vav.salmon_service.entity.FishStatistic;
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

    public void addDiapason(FishStatistic st) {
        Diapason diapason = new Diapason(st.getParamName(), st.getAverage() - st.getSigma(),
                st.getAverage() + st.getSigma());
        diapasons.add(diapason);
    }

    public record Diapason (
        String fieldName,
        double yellowBound,
        double redBound ) {}
}
