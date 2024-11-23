--liquibase formatted sql
--changeset negrash:add_columns_and_rename_table
ALTER TABLE selects_grading_male ADD gender varchar;
ALTER TABLE selects_grading_male ADD weight int;
ALTER TABLE selects_grading_male ADD weight_of_eggs int;
ALTER TABLE selects_grading_male ADD weight_of_single_egg int;
ALTER TABLE selects_grading_male ADD caviar_proportion real;
ALTER TABLE selects_grading_male ADD working_fertility real;
ALTER TABLE selects_grading_male ADD percent_of_egg_fertilization  int;
ALTER TABLE selects_grading_male ADD percent_of_embryo_survival  int;
ALTER TABLE selects_grading_male ADD percent_of_embryo_yield  int;
ALTER TABLE selects_grading_male ADD percent_of_death_to_the_peephole  int;
ALTER TABLE selects_grading_male ADD percent_of_death_after_the_peephole  int;
ALTER TABLE selects_grading_male ADD post_ocular_developmental_abnormalities  int;
ALTER TABLE selects_grading_male ADD percent_of_hatching_in_two_days  int;
ALTER TABLE selects_grading_male ADD percent_of_went_up_on_the_float  int;
ALTER TABLE selects_grading_male ADD feed_factor real;
ALTER TABLE selects_grading_male ADD fillet_pigmentation varchar;
ALTER TABLE selects_grading_male ADD active_feeding_survival_rate  int;
ALTER TABLE selects_grading_male ADD disease_resistance  int;
ALTER TABLE selects_grading_male ADD reproductive_index  int;
ALTER TABLE selects_grading_male ADD relative_fecundity  int;

UPDATE selects_grading_male SET gender = 'male', weight = 3000;

ALTER TABLE selects_grading_male RENAME TO selects_grading;