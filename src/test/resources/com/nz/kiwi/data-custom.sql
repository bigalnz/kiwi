INSERT INTO bird (id, name, sex, status, taxa, comment)
VALUES (1, 'Natasha', 'FEMALE', 'ALIVE', 1, 'Big beak'),
       (2, 'Jono', 'MALE', 'ALIVE', 2, 'Fast runner'),
       (3, 'Clara', 'FEMALE', 'ALIVE', 3, 'Caught by John 2022');

INSERT INTO health_check (id, catch_date_time, release_date_time, bird_id, location)
VALUES (1, '2023-06-01 13:00:00', '2026-06-01 14:00:00', 1, ST_PointFromText('POINT(-36.5 174.5)', 4326)),
       (2, '2023-06-02 14:00:00', '2023-06-02 16:00', 1, ST_PointFromText('POINT(-32.5 174.5)', 4326)),
       (3, '2023-06-03 14:00:00', '2023-06-03 16:00', 1, ST_PointFromText('POINT(36.5 174.5)', 4326)),
       (4, '2023-06-04 14:00:00', '2023-06-04 16:00', 1, ST_PointFromText('POINT(-36.5 174.5)', 4326)),
       (5, '2023-06-05 11:18:00', '2023-06-05 11:45:00', 2, ST_PointFromText('POINT(-35.5 173.5)', 4326));

INSERT INTO length_measurements (task_id, health_check_id, beak_length, tarsus_depth, tarsus_length, tarsus_width)
VALUES (5, 1, '98.0', '9.8', '45.0', '6.3'),
       (6, 1, '98.4', '9.5', '44.3', '5.5'),
       (7, 1, '98.2', '9.8', '44.1', '5.7'),
       (8, 5, '66', '15', '30', '7'),
       (9, 3, '99.2', '10.8', '45.1', '6.7'),
       (10, 3, '99.3', '10.9', '45.2', '7.8');

INSERT INTO weight_measurements (task_id, health_check_id, weight)
VALUES (11, 2, '3.2'),
       (12, 3, '3.1'),
       (13, 3, '3.05');

INSERT INTO pit (task_id, health_check_id, code, date_inserted)
VALUES (14, 1, 'ABC123', '2023-06-01'),
       (15, 5, 'DEF789', '2023-06-01');

INSERT INTO transmitter (task_id, health_check_id, channel, comment, finish, start, transmitter_task_type, tuning)
VALUES (16, 1, '50', 'test', '2023-06-01 13:00:00', '2023-06-01 12:45:00', 'ATTACHED', '1.5'),
       (17, 2, '51', 'test', '2023-07-01 14:45:00', '2023-07-01 15:14:13', 'REPLACED', '-2.0');

INSERT INTO person (id, firstname, lastname)
VALUES (6, 'Steve', 'McQueen'),
       (7, 'Julia', 'Roberts'),
       (8, 'Clint', 'Eastwood');

INSERT INTO chick_timer (id, bird_id, location, person_recorder_id, ct_date_time, beats_per_minute, d_change_state,
                         d_hatch, d_desert_alert,
                         wks_tx_life, emergence_hour, yesterday, two_days_ago, mean_four_days)
VALUES (1, 1, ST_PointFromText('POINT(-36.5 174.5)', 4326), 6, '2023-06-28 11:14:00', 38, 2, 5, 5, 7, 7, 8, 9, 7);

UPDATE bird
SET current_transmitter_id = '16',
    current_pit_id         = '14'
WHERE bird.id = 1;

UPDATE bird
SET current_transmitter_id = '17',
    current_pit_id         = '15'
WHERE bird.id = 2;


