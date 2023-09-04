-- create one bird Dario #50
-- 1 HealthCheck 2021 - No tasks
-- 1 HealthCheck 2022 - 3 Length, 1 Weight, 1 Pit, 1 Tx
-- 1 HealthCheck 2023 - 2 Length, 2 Weight, 0 Pit, 1 Tx
INSERT INTO BIRD (id, name, sex, status, taxa, comment)
VALUES (50, 'Dario', 'MALE', 'ALIVE', 1, 'This is Dario - no 3 Health Checks over 3 years.');

INSERT INTO HEALTH_CHECK (id, catch_date_time, release_date_time, bird_id, location, holder_id, measurer_id)
VALUES (51, '2021-06-01 13:00:00', '2021-06-01 14:00:00', 50, POINT(-36.86, 175.18), 7, 8),
       (52, '2022-06-02 14:00:00', '2022-06-02 16:00', 50, POINT(-36.84, 175.19), 7, 8),
       (53, '2023-06-03 14:00:00', '2023-06-03 16:00', 50, POINT(-36.82, 175.15), 6, 8);

-- 3 lengths in 2022 and 2 in 2023
INSERT INTO LENGTH_MEASUREMENTS (task_id, health_check_id, beak_length, tarsus_depth, tarsus_length, tarsus_width)
VALUES (54, 52, '98.0', '9.8', '45.3', '6.35'),
       (55, 52, '98.4', '9.9', '45.56', '6.55'),
       (56, 52, '98.3', '10.1', '45.23', '6.23'),
       (57, 53, '101.4', '11.5', '47.3', '7.5'),
       (58, 53, '102.2', '11.8', '47.1', '7.7');

INSERT INTO WEIGHT_MEASUREMENTS (task_id, health_check_id, weight)
VALUES (53, 52, '3.2'),
       (54, 53, '3.1');
--(61, 53, '3.08');

INSERT INTO PIT (task_id, health_check_id, code, date_inserted)
VALUES (62, 52, 'H0C4B3X', '2022-02-06');

INSERT INTO TRANSMITTER (task_id, health_check_id, channel, comment, finish, start, transmitter_task_type, tuning)
VALUES (63, 52, '50', 'test', '2022-06-01 13:00:00', '2022-06-01 12:45:00', 'REPLACED', '1.5'),
       (64, 53, '50', 'test', '2023-07-01 14:45:00', '2023-07-01 15:14:13', 'ATTACHED', '-2.0');

