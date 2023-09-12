CREATE TABLE bird
(
    id                     BIGINT       NOT NULL,
    name                   VARCHAR(255) NULL,
    status                 VARCHAR(255) NULL,
    date_deceased          date         NULL,
    sex                    VARCHAR(255) NULL,
    taxa                   INT          NULL,
    comment                LONGTEXT     NULL,
    current_transmitter_id BIGINT       NULL,
    current_pit_id         BIGINT       NULL,
    CONSTRAINT pk_bird PRIMARY KEY (id)
);

CREATE TABLE chick_timer
(
    id                 BIGINT   NOT NULL,
    location           GEOMETRY NULL,
    ct_date_time       datetime NULL,
    person_recorder_id BIGINT   NULL,
    bird_id            BIGINT   NULL,
    beats_per_minute   INT      NULL,
    d_change_state     INT      NULL,
    d_hatch            INT      NULL,
    d_desert_alert     INT      NULL,
    wks_tx_life        INT      NULL,
    emergence_hour     INT      NULL,
    yesterday          INT      NULL,
    two_days_ago       INT      NULL,
    mean_four_days     INT      NULL,
    CONSTRAINT pk_chicktimer PRIMARY KEY (id)
);

CREATE TABLE health_check
(
    id                BIGINT   NOT NULL,
    bird_id           BIGINT   NOT NULL,
    catch_date_time   datetime NULL,
    release_date_time datetime NULL,
    location          GEOMETRY NULL,
    holder_id         BIGINT   NULL,
    measurer_id       BIGINT   NULL,
    CONSTRAINT pk_health_check PRIMARY KEY (id)
);

CREATE TABLE length_measurements
(
    task_id         BIGINT NOT NULL,
    health_check_id BIGINT NULL,
    beak_length     DOUBLE NULL,
    tarsus_length   DOUBLE NULL,
    tarsus_width    DOUBLE NULL,
    tarsus_depth    DOUBLE NULL,
    CONSTRAINT pk_lengthmeasurements PRIMARY KEY (task_id)
);

CREATE TABLE person
(
    id        BIGINT       NOT NULL,
    firstname VARCHAR(255) NULL,
    lastname  VARCHAR(255) NULL,
    CONSTRAINT pk_person PRIMARY KEY (id)
);

CREATE TABLE pit
(
    task_id         BIGINT       NOT NULL,
    health_check_id BIGINT       NULL,
    code            VARCHAR(255) NULL,
    date_inserted   date         NULL,
    comment         LONGTEXT     NULL,
    CONSTRAINT pk_pit PRIMARY KEY (task_id)
);

CREATE TABLE task
(
    task_id         BIGINT NOT NULL,
    health_check_id BIGINT NULL,
    CONSTRAINT pk_task PRIMARY KEY (task_id)
);

CREATE TABLE test
(
    id                BIGINT   NOT NULL,
    location          GEOMETRY NULL,
    release_date_time datetime NULL,
    CONSTRAINT pk_test PRIMARY KEY (id)
);

CREATE TABLE transmitter
(
    task_id               BIGINT       NOT NULL,
    health_check_id       BIGINT       NULL,
    channel               INT          NULL,
    tuning                DOUBLE       NULL,
    start                 datetime     NULL,
    finish                datetime     NULL,
    transmitter_task_type VARCHAR(255) NULL,
    comment               LONGTEXT     NULL,
    CONSTRAINT pk_transmitter PRIMARY KEY (task_id)
);

CREATE TABLE weight_measurements
(
    task_id         BIGINT NOT NULL,
    health_check_id BIGINT NULL,
    weight          DOUBLE NULL,
    CONSTRAINT pk_weightmeasurements PRIMARY KEY (task_id)
);

ALTER TABLE bird
    ADD CONSTRAINT uc_bird_name UNIQUE (name);

ALTER TABLE pit
    ADD CONSTRAINT uc_pit_code UNIQUE (code);

ALTER TABLE bird
    ADD CONSTRAINT FK_BIRD_ON_CURRENT_PIT FOREIGN KEY (current_pit_id) REFERENCES pit (task_id);

ALTER TABLE bird
    ADD CONSTRAINT FK_BIRD_ON_CURRENT_TRANSMITTER FOREIGN KEY (current_transmitter_id) REFERENCES transmitter (task_id);

ALTER TABLE chick_timer
    ADD CONSTRAINT FK_CHICKTIMER_ON_BIRD FOREIGN KEY (bird_id) REFERENCES bird (id);

ALTER TABLE chick_timer
    ADD CONSTRAINT FK_CHICKTIMER_ON_PERSONRECORDER FOREIGN KEY (person_recorder_id) REFERENCES person (id);

ALTER TABLE health_check
    ADD CONSTRAINT FK_HEALTH_CHECK_ON_BIRD FOREIGN KEY (bird_id) REFERENCES bird (id);

ALTER TABLE health_check
    ADD CONSTRAINT FK_HEALTH_CHECK_ON_HOLDER FOREIGN KEY (holder_id) REFERENCES person (id);

ALTER TABLE health_check
    ADD CONSTRAINT FK_HEALTH_CHECK_ON_MEASURER FOREIGN KEY (measurer_id) REFERENCES person (id);

ALTER TABLE length_measurements
    ADD CONSTRAINT FK_LENGTHMEASUREMENTS_ON_HEALTHCHECK FOREIGN KEY (health_check_id) REFERENCES health_check (id);

ALTER TABLE pit
    ADD CONSTRAINT FK_PIT_ON_HEALTHCHECK FOREIGN KEY (health_check_id) REFERENCES health_check (id);

ALTER TABLE task
    ADD CONSTRAINT FK_TASK_ON_HEALTHCHECK FOREIGN KEY (health_check_id) REFERENCES health_check (id);

ALTER TABLE transmitter
    ADD CONSTRAINT FK_TRANSMITTER_ON_HEALTHCHECK FOREIGN KEY (health_check_id) REFERENCES health_check (id);

ALTER TABLE weight_measurements
    ADD CONSTRAINT FK_WEIGHTMEASUREMENTS_ON_HEALTHCHECK FOREIGN KEY (health_check_id) REFERENCES health_check (id);