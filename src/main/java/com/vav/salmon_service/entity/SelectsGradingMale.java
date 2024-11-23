package com.vav.salmon_service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "selects_grading_male")
public class SelectsGradingMale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "selects_grading_male_seq")
    @SequenceGenerator(name = "selects_grading_male_seq", sequenceName = "selects_grading_male_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "marker")
    private String tag;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_hatching")
    private LocalDate dateOfHatch;

    @Column(name = "date_of_start_feeding")
    private LocalDate dateOfFirstFeed;

    @Column(name = "estimated_age_days")
    private Integer ageInDays;

    @Column(name = "estimated_age_degree_days")
    private Integer ageInDayDegrees;

    //абсолютные показатели телосложения
    @Column(name = "absolute_length")
    private Integer lengthAbsolute;

    @Column(name = "body_length_before_end_scale_cover")
    private Integer lengthBeforeScales;

    @Column(name = "body_length")
    private Integer lengthBody;

    @Column(name = "head_length")
    private Integer lengthHead;

    @Column(name = "body_height")
    private Integer heightBody;

    @Column(name = "back_thickness")
    private Integer thicknessOfBack;

    @Column(name = "fatness_index")
    private Double fatnessFactor;

    @Column(name = "head_index")
    private Double headFactor;

    @Column(name = "thickness_index")
    private Double thickFactor;

    @Column(name = "index_runnability")
    private Double runnabilityIndex;

    //абсолютные показатели репродукции
    @Column(name = "ejaculate_volume")
    private Integer ejaculateVolume;

    @Column(name = "spermatocrit_value")
    private Double spermConcentration;

    @Column(name = "sperm_motility_time")
    private Integer spermMotilityTime;

    //дневник самца
    @Column(name = "diary")
    private String diary;

}
