INSERT INTO BIRD (id, name, sex, status, taxa, comment)
VALUES (70, 'Bow', 'MALE', 'ALIVE', 1, 'This is Bow - no 3 Health Checks over 3 years.'),
       (50, 'Dario', 'MALE', 'ALIVE', 1, 'This is Dario - no 3 Health Checks over 3 years.'),
       (40, 'Minnie', 'FEMALE', 'ALIVE', 1, 'This is Minnie - no Health Checks.');

-- create chicktimer data
INSERT INTO chick_timer (id, bird_id, location, user_recorder_id, ct_date_time, beats_per_minute, d_change_state,
                         d_hatch, d_desert_alert,
                         wks_tx_life, emergence_hour, yesterday, two_days_ago, mean_four_days)
VALUES (10, 70, St_PointFromText('POINT(-36.4 175.51)', 4326), 6, '2021-06-28 11:14:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (11, 50, ST_PointFromText('POINT(-36.5 175.52)', 4326), 6, '2022-03-21 14:16:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (12, 50, ST_PointFromText('POINT(-36.3 175.53)', 4326), 6, '2023-04-28 10:14:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (13, 50, ST_PointFromText('POINT(-36.45 175.54)', 4326), 6, '2021-02-11 09:22:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (14, 50, ST_PointFromText('POINT(-36.43 175.52)', 4326), 6, '2021-01-14 08:14:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (15, 40, ST_PointFromText('POINT(-36.45 175.53)', 4326), 6, '2022-03-16 12:33:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (16, 40, ST_PointFromText('POINT(-36.23 175.54)', 4326), 6, '2023-04-14 14:56:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (17, 40, ST_PointFromText('POINT(-36.45 175.56)', 4326), 6, '2021-05-22 15:34:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (18, 50, ST_PointFromText('POINT(-36.56 175.51)', 4326), 6, '2020-03-14 15:14:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411),
       (19, 50, ST_PointFromText('POINT(-36.51 175.52)', 4326), 6, '2021-08-01 12:09:00', 38, 43, 22, 22, 410, 511, 44,
        54, 411);

