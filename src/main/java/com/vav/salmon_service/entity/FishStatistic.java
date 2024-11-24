package com.vav.salmon_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = "fish_statistics")
public class FishStatistic {
    @Id
    @Column(name = "param_name", nullable = false, length = 256)
    private String paramName;

    @Column(name = "average", nullable = false)
    private Double average;

    @Column(name = "maximum", nullable = false)
    private Double maximum;

    @Column(name = "minimum", nullable = false)
    private Double minimum;

    @Column(name = "sigma", nullable = false)
    private Double sigma;

    @Column(name = "count", nullable = false)
    private Long count;

}