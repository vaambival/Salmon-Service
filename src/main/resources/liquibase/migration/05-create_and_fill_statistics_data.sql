--liquibase formatted sql
--changeset vkurov:create-table-statistic
CREATE TABLE IF NOT EXISTS fish_statistics (
    param_name varchar CONSTRAINT fs_pk PRIMARY KEY,
    average real CONSTRAINT not null,
    maximum real CONSTRAINT not null,
    minimum real CONSTRAINT not null,
    sigma real CONSTRAINT not null,
    count bigint CONSTRAINT not null
);

insert into fish_statistics (param_name, average, maximum, minimum, sigma, count) VALUES
('weight', 2298, 3010, 1990, 199, 600),
('lengthBody', 55.5, 60.5, 50, 2, 600),
('heightBody', 13, 14, 12, 0.5, 600),
('thicknessOfBack', 6.23, 8, 5.5, 0.4, 600),
('weightOfEggs', 423, 574, 304, 48, 600),
('weightOfSingleEgg', 92, 110, 70, 8, 600),
('fatnessFactor', 1.34, 1.6, 1.2, 0.1, 600),
('thickFactor', 11, 13, 10, 0.62, 600),
('runnabilityIndex', 23, 26, 21, 1, 600),
('headFactor', 3, 4, 2, 0.1, 600),
('caviarProportion', 18, 22, 10, 2, 600),
('workingFertility', 5, 7, 1, 1, 600),
('relativeFecundity', 2556.5, 3860.5, 1250, 72, 600),
('reproductiveIndex', 255.5, 360.5, 150, 10, 600),
('percentOfDeathToThePeephole', 0.46, 1.83, 0, 0.4, 600),
('percentOfDeathAfterThePeephole', 4.5, 30.5, 0, 5, 600),
('percentOfEggFertilization', 98, 100, 70, 5, 600),
('percentOfEmbryoSurvival', 95, 99.9, 75, 5, 600);