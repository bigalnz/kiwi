INSERT INTO BIRD (name, sex, status, taxa, comment)
VALUES ('Natasha', 'FEMALE', 'ALIVE', 1, 'Big beak'),
       ('Jono','MALE' , 'ALIVE', 2, 'Fast runner'),
       ('Clara', 'FEMALE', 'ALIVE', 3, 'Caught by John 2022');

INSERT INTO HEALTH_CHECK (catch_date_time, release_date_time, bird_id)
VALUES ('2023-06-01 13:00:00', '2026-06-01 14:00:00', 1),
       ('2023-06-02 14:00:00', '2023-06-02 16:00', 1),
       ('2023-06-03 14:00:00', '2023-06-03 16:00', 1),
       ('2023-06-04 14:00:00', '2023-06-04 16:00', 1),
       ('2023-06-05 11:18:00', '2023-06-05 11:45:00', 2);

/*INSERT INTO TASK (task_id, health_check_health_checkid)
VALUES (1,1),
(2,1);*/

INSERT INTO LENGTH_MEASUREMENTS (task_id, health_check_id, beak_length, tarsus_depth, tarsus_length, tarsus_width)
VALUES (5, 1, '98.0', '9.8', '45.0', '6.3'),
(6,1, '98.4', '9.5', '44.3', '5.5'),
(7,1, '98.2', '9.8', '44.1', '5.7');

INSERT INTO WEIGHT_MEASUREMENTS (task_id, health_check_id, weight)
VALUES (8, 2, '3.2'),
    (9, 2, '3.1');

INSERT INTO PIT (task_id, health_check_id, code, date_inserted)
VALUES (1,1, 'ABC123', '2023-06-01'),
       (4, 5, 'DEF789', '2023-06-01');

INSERT INTO TRANSMITTER (task_id, health_check_id, channel, comment, finish, start, transmitter_task_type, tuning)
VALUES (2,1, '50', 'test', '2023-06-01 13:00:00', '2023-06-01 12:45:00', 'ATTACHED', '1.5' ),
       (3, 2, '51', 'test', '2023-07-01 14:45:00', '2023-07-01 15:14:13', 'REPLACED', '-2.0' );

UPDATE BIRD SET
 current_transmitter_id = '3',
 current_pit_id = '4'
WHERE
 bird.id=1;

UPDATE BIRD SET
 current_transmitter_id = '2'
WHERE
bird.id=2;