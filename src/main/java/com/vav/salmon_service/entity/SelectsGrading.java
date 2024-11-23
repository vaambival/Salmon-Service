package com.vav.salmon_service.entity;


import com.vav.salmon_service.common.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "selects_grading")
@FieldNameConstants
public class SelectsGrading {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "selects_grading_male_seq")
    @SequenceGenerator(name = "selects_grading_male_seq", sequenceName = "selects_grading_male_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "marker")
    private String tag;

    @Column(name = "gender")
    private String gender;

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

    @Column(name = "weight")
    private Integer weight;

    //абсолютные показатели репродукции
    @Column(name = "ejaculate_volume")
    private Integer ejaculateVolume;

    @Column(name = "spermatocrit_value")
    private Double spermConcentration;

    @Column(name = "sperm_motility_time")
    private Integer spermMotilityTime;

    // Репродуктивные показатели
    @Column(name = "weight_of_eggs")
    private Integer weightOfEggs;

    @Column(name = "weight_of_single_egg")
    private Integer weightOfSingleEgg;

    @Column(name = "caviar_proportion")
    private Double caviarProportion;

    @Column(name = "working_fertility")
    private Double workingFertility;

    @Column(name = "reproductive_index")
    private Double reproductiveIndex;

    @Column(name = "relative_fecundity")
    private Double relativeFecundity;

    // Оценка по качеству потомства
    @Column(name = "percent_of_egg_fertilization")
    private Integer percentOfEggFertilization;

    @Column(name = "percent_of_embryo_survival")
    private Integer percentOfEmbryoSurvival;

    @Column(name = "percent_of_embryo_yield")
    private Integer percentOfEmbryoYield;

    @Column(name = "percent_of_death_to_the_peephole")
    private Integer percentOfDeathToThePeephole;

    @Column(name = "percent_of_death_after_the_peephole")
    private Integer percentOfDeathAfterThePeephole;

    @Column(name = "post_ocular_developmental_abnormalities")
    private Integer postOcularDevelopmentalAbnormalities;

    @Column(name = "percent_of_hatching_in_two_days")
    private Integer percentOfHatchingInTwoDays;

    @Column(name = "percent_of_went_up_on_the_float")
    private Integer percentOfWentUpOnTheFloat;

    // Оценка конверсии корма
    @Column(name = "feed_factor")
    private Double feedFactor;

    @Column(name = "fillet_pigmentation")
    private String filletPigmentation;

    @Column(name = "active_feeding_survival_rate")
    private Integer activeFeedingSurvivalRate;

    @Column(name = "disease_resistance")
    private Integer diseaseResistance;

    //дневник
    @Column(name = "diary")
    private String diary;

    public boolean isFemale() {
        return StringUtils.equalsIgnoreCase(gender, Gender.FEMALE.name());
    }
}
