--liquibase formatted sql
--changeset negrash:fill_data_selects_grading_female
INSERT INTO selects_grading (id,
marker,
created,
date_of_birth,
date_of_hatching,
date_of_start_feeding,
estimated_age_days,
estimated_age_degree_days,
absolute_length,
body_length_before_end_scale_cover,
body_length,
head_length,
body_height,
back_thickness,
fatness_index,
head_index,
thickness_index,
index_runnability,
gender,
weight,
weight_of_eggs,
weight_of_single_egg,
caviar_proportion,
working_fertility,
percent_of_egg_fertilization,
percent_of_embryo_survival,
percent_of_embryo_yield,
percent_of_death_to_the_peephole,
percent_of_death_after_the_peephole,
post_ocular_developmental_abnormalities,
percent_of_hatching_in_two_days,
percent_of_went_up_on_the_float,
reproductive_index,
relative_fecundity,
diary) VALUES
(5001, 'Marker_5001', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3340, 232, 62, 0.18, 2987, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5001'),
(5002, 'Marker_5002', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3340, 232, 62, 0.18, 2987, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5002'),
(5003, 'Marker_5003', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3340, 232, 62, 0.18, 2987, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5003'),
(5004, 'Marker_5004', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3340, 232, 62, 0.18, 2987, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5004'),
(5005, 'Marker_5005', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3340, 232, 62, 0.18, 2987, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5005'),
(5006, 'Marker_5006', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3340, 232, 62, 0.18, 2987, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5006'),
(5007, 'Marker_5007', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3340, 232, 62, 0.18, 2447, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5007'),
(5008, 'Marker_5008', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3340, 232, 62, 0.18, 2447, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5008'),
(5009, 'Marker_5009', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3340, 232, 62, 0.18, 2447, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5009'),
(5010, 'Marker_5010', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3344, 232, 62, 0.18, 2447, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5010'),
(5011, 'Marker_5011', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3344, 232, 62, 0.18, 2447, 77, 88, 78, 4, 1, 1, 64, 72, 280, 2553, 'Diary 5011'),
(5012, 'Marker_5012', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3344, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5012'),
(5013, 'Marker_5013', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3344, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5013'),
(5014, 'Marker_5014', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5014'),
(5015, 'Marker_5015', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5015'),
(5016, 'Marker_5016', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5016'),
(5017, 'Marker_5017', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5017'),
(5018, 'Marker_5018', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5018'),
(5019, 'Marker_5019', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5019'),
(5020, 'Marker_5020', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5020'),
(5021, 'Marker_5021', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5021'),
(5022, 'Marker_5022', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5022'),
(5023, 'Marker_5023', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2553, 'Diary 5023'),
(5024, 'Marker_5024', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2343, 'Diary 5024'),
(5025, 'Marker_5025', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2343, 'Diary 5025'),
(5026, 'Marker_5026', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2343, 'Diary 5026'),
(5027, 'Marker_5027', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2343, 'Diary 5027'),
(5028, 'Marker_5028', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2343, 'Diary 5028'),
(5029, 'Marker_5029', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 286, 2343, 'Diary 5029'),
(5030, 'Marker_5030', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2343, 'Diary 5030'),
(5031, 'Marker_5031', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2343, 'Diary 5031'),
(5032, 'Marker_5032', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5032'),
(5033, 'Marker_5033', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5033'),
(5034, 'Marker_5034', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5034'),
(5035, 'Marker_5035', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5035'),
(5036, 'Marker_5036', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5036'),
(5037, 'Marker_5037', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5037'),
(5038, 'Marker_5038', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5038'),
(5039, 'Marker_5039', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5039'),
(5040, 'Marker_5040', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5040'),
(5041, 'Marker_5041', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3244, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5041'),
(5042, 'Marker_5042', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5042'),
(5043, 'Marker_5043', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 2340, 'Diary 5043'),
(5044, 'Marker_5044', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3640, 'Diary 5044'),
(5045, 'Marker_5045', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3640, 'Diary 5045'),
(5046, 'Marker_5046', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3640, 'Diary 5046'),
(5047, 'Marker_5047', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5047'),
(5048, 'Marker_5048', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5048'),
(5049, 'Marker_5049', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5049'),
(5050, 'Marker_5050', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5050'),
(5051, 'Marker_5051', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3254, 232, 62, 0.18, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5051'),
(5052, 'Marker_5052', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3254, 232, 62, 0.20, 2442, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5052'),
(5053, 'Marker_5053', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5053'),
(5054, 'Marker_5054', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5054'),
(5055, 'Marker_5055', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5055'),
(5056, 'Marker_5056', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5056'),
(5057, 'Marker_5057', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5057'),
(5058, 'Marker_5058', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5058'),
(5059, 'Marker_5059', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5059'),
(5060, 'Marker_5060', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5060'),
(5061, 'Marker_5061', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3224, 232, 62, 0.20, 2932, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5061'),
(5062, 'Marker_5062', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3424, 232, 62, 0.20, 2032, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5062'),
(5063, 'Marker_5063', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3424, 232, 62, 0.20, 2032, 77, 88, 78, 4, 1, 1, 64, 72, 236, 3600, 'Diary 5063'),
(5064, 'Marker_5064', NOW(), '2023-01-15', '2023-02-20', '2023-03-10', 100, 3000, 120, 110, 100, 20, 15, 10, 12.5, 18.0, 10.2, 90.0, 'female', 3424, 232, 62, 0.20, 2032, 77, 88, 78, 4, 1, 1, 64, 72, 266, 3600, 'Diary 5064'),
(5065, 'Marker_5065', NOW(), '2023-02-28', '2023-03-15', '2023-04-01', 110, 3500, 130, 120, 110, 22, 16, 12, 13.0, 19.0, 11.0, 92.0, 'female', 3424, 232, 62, 0.20, 2032, 77, 88, 78, 4, 1, 1, 64, 72, 266, 3600, 'Diary 5065'),
(5066, 'Marker_5066', NOW(), '2023-03-10', '2023-04-10', '2023-04-20', 100, 2800, 115, 105, 111, 18, 14, 10, 11.8, 17.5, 9.80, 88.0, 'female', 3424, 232, 62, 0.20, 2032, 77, 88, 78, 4, 1, 1, 64, 72, 266, 3600, 'Diary 5066'),
(5067, 'Marker_5067', NOW(), '2023-12-01', '2024-01-10', '2024-01-25', 100, 2250, 100, 110, 60, 12, 8, 7, 8.2, 12.1, 7.5, 85.0,      'female', 3424, 232, 62, 0.20, 2032, 77, 88, 78, 4, 1, 1, 64, 72, 266, 3600, 'Diary 5067');