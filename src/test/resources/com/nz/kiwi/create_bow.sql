-- create one bird Bow #70
-- 1 HealthCheck 2021 - 4 lengths 3 weight
-- 1 HealthCheck 2022 - 3 Length, 1 Weight, 1 Pit, 1 Tx
-- 1 HealthCheck 2023 - 2 Length, 2 Weight, 0 Pit, 1 Tx
-- Has Current Pit B0C4B3X and Tx 55
INSERT INTO BIRD (id, name, sex, status, taxa, comment)
VALUES (70, 'Bow', 'MALE', 'ALIVE', 1, 'This is Bow - no 3 Health Checks over 3 years.');

INSERT INTO HEALTH_CHECK (id, catch_date_time, release_date_time, bird_id, location, holder_id, measurer_id)
VALUES (71, '2021-06-01 13:00:00', '2021-06-01 14:00:00', 70, POINT(-36.86, 175.18), 7, 8),
       (72, '2022-06-02 14:00:00', '2022-06-02 16:00', 70, POINT(-36.84, 175.19), 7, 8),
       (73, '2023-06-03 14:00:00', '2023-06-03 16:00', 70, POINT(-36.82, 175.15), 6, 8);

-- 3 lengths in 2022 and 2 in 2023
INSERT INTO LENGTH_MEASUREMENTS (task_id, health_check_id, beak_length, tarsus_depth, tarsus_length, tarsus_width)
VALUES (60, 71, '98.0', '9.8', '45.3', '6.35'),
       (61, 71, '98.4', '9.9', '45.56', '6.55'),
       (62, 71, '98.3', '10.1', '45.23', '6.23'),
       (63, 71, '98.4', '11.5', '47.3', '7.5'),
       (64, 72, '101.2', '11.8', '47.1', '7.7'),
       (65, 72, '101.9', '11.9', '47.9', '7.9'),
       (66, 72, '101.4', '11.5', '47.4', '7.7'),
       (67, 73, '103.9', '11.9', '47.9', '8.7'),
       (68, 73, '104.4', '12.5', '48.4', '8.7');

INSERT INTO WEIGHT_MEASUREMENTS (task_id, health_check_id, weight)
VALUES (59, 71, '2.6'),
       (60, 71, '2.55'),
       (61, 71, '2.75'),
       (62, 72, '2.75'),
       (63, 73, '2.75'),
       (64, 73, '2.75');

INSERT INTO PIT (task_id, health_check_id, code, date_inserted)
VALUES (66, 71, 'B0C4B3X', '2022-01-06');

INSERT INTO TRANSMITTER (task_id, health_check_id, channel, comment, finish, start, transmitter_task_type, tuning)
VALUES (66, 71, '55', 'Ch 55 replaced', '2022-06-01 13:00:00', '2022-06-01 12:45:00', 'REPLACED', '1.5'),
       (67, 72, '55', 'Ch 55 attached', '2023-07-01 14:45:00', '2023-07-01 15:14:13', 'ATTACHED', '-2.0');

UPDATE BIRD
SET current_transmitter_id = '67',
    current_pit_id         = '66'
WHERE bird.id = 70;

