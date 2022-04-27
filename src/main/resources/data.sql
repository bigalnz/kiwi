INSERT INTO BIRD (name, sex, status, taxa, comment)
VALUES ('Natasha', 'FEMALE', 'ALIVE', 1, 'Big beak'),
       ('Jono','MALE' , 'ALIVE', 2, 'Fast runner'),
       ('Clara', 'FEMALE', 'ALIVE', 3, 'Caught by John 2022'),
       ('Maaka', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Andre', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Kobi', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Vincent', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Dario', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Minnie', 'FEMALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Ponui', 'FEMALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Tako', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Mark', 'MALE', 'ALIVE', 1, 'Fit and healthy'),
       ('Dennis', 'MALE', 'ALIVE', 1, 'Fit and healthy');
INSERT INTO HEALTH_CHECK (behaviour, body_condition, capture, catch_date, catch_time, catching_comment, disease_comment, lice_coverage, lice_location, location, parasite_coverage, parasite_location, release_time, skin_disorder, bird_id)
VALUES ('1', '1', '1', '2022-03-14', '18:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '19:32:01.000', '1', '1' ),
       ('1', '1', '1', '2021-03-12', '15:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '16:35:01.000', '1', '5' ),
       ('1', '1', '1', '2020-03-14', '13:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '14:03:01.000', '1', '3' ),
       ('1', '1', '1', '2016-04-14', '12:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '13:56:01.000', '1', '1' ),
       ('1', '1', '1', '2015-03-14', '11:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '12:32:01.000', '1', '1' ),
       ('1', '1', '1', '2017-05-18', '12:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '13:56:01.000', '1', '2' ),
       ('1', '1', '1', '2014-06-04', '11:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '12:32:01.000', '1', '2' ),
       ('1', '1', '1', '2013-06-10', '18:47:00.000', 'No comment catch', 'No comment disease', '1', '1',  ST_GeomFromText('POINT(1 1)'), '1', '1', '19:27:01.000', '1', '1' );
INSERT INTO PIT (code, comment, health_check_id)
VALUES  ('0007DDFA8B', '', 8),
        ('0007E0DE4A', '', 2),
        ('0007E0DEEF', '', 3),
        ('0007E0DF6A', '', 4),
        ('0007E0DDE6', '', 5),
        ('0007E0E0C0', '', 6),
        ('0007E01F5D', '', 7),
        ('0007E0E0CC', '', NULL),
        ('0007E0DF5B', '', NULL),
        ('0007E0DF45', '', NULL);
INSERT INTO WEIGHT (measurement, health_check_id)
VALUES (2.3, '1'),
       (2.25, '2'),
       (1.7, '3'),
       (1.8, '3'),
       (2.20, '1'),
       (2.1, '1'),
       (1.85, '3');
INSERT INTO TARSUS_LENGTH (measurement, health_check_id)
VALUES (16.4, '1'),
       (16.1, '1'),
       (15.2, '1'),
       (12.8, '2'),
       (11.1, '2');
INSERT INTO TARSUS_DEPTH (measurement, health_check_id)
VALUES (16.4, '1'),
       (16.1, '1'),
       (15.2, '1'),
       (12.8, '2'),
       (11.1, '2');
INSERT INTO TARSUS_WIDTH (measurement, health_check_id)
VALUES (16.4, '1'),
       (16.1, '1'),
       (15.2, '1'),
       (12.8, '2'),
       (11.1, '2');
INSERT INTO BEAK_LENGTH (measurement, health_check_id)
VALUES (195.3, 1),
       (194.5, 1),
       (196.2, 1),
       (112.8, 2),
       (111.1, 2);
INSERT INTO TRANSMITTER (channel, channel_offset, health_check_id)
VALUES (1, -1,  1),
       (3, 1,  2),
       (3, -2, 4),
       (7, 2.5, NULL),
       (9, 2.25, NULL),
       (11, 3,  NULL),
       (13, 2,  NULL),
       (15, -3, NULL);

