package com.nz.kiwi.model;
;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nz.kiwi.dto.BirdDTO;
import com.nz.kiwi.dto.BirdViewDTO;
import com.nz.kiwi.enumeration.BirdStatus;
import com.nz.kiwi.enumeration.Sex;
import com.nz.kiwi.enumeration.Taxa;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data

@NamedNativeQuery(
        // QUERY TO FIND 1 BIRD EXTENDED WITH NEWEST HEALTH CHECK, NEWWEST CHANNEL AND NEWEST PIT CODE
        // USE IN BASE BIRD VIEW DTO
        name = "find_bird_extended",
        query = "WITH cte1 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT id AS hc_id, bird_id, catch_date\n" +
                "                  , ROW_NUMBER() OVER (PARTITION BY bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM HEALTH_CHECK\n" +
                "         ) AS cte1a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "   , cte2 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT p.id AS pit_id\n" +
                "                  , hc.bird_id\n" +
                "                  , p.Health_Check_Id\n" +
                "                  , p.code\n" +
                "                  , hc.catch_date as catchdate\n" +
                "                  , RANK() OVER (PARTITION BY hc.bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM PIT          AS p\n" +
                "                      JOIN HEALTH_CHECK AS hc\n" +
                "                           ON p.Health_Check_Id = hc.id\n" +
                "         ) AS cte2a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "   , cte3 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT t.id AS transmitter_id\n" +
                "                  , hc.bird_id\n" +
                "                  , t.Health_Check_Id\n" +
                "                  , t.channel\n" +
                "                  , hc.catch_date as catchdate\n" +
                "                  , RANK() OVER (PARTITION BY hc.bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM TRANSMITTER          AS t\n" +
                "                      JOIN HEALTH_CHECK AS hc\n" +
                "                           ON t.Health_Check_Id = hc.id\n" +
                "         ) AS cte3a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "SELECT b.id AS birdId, b.name, b.sex, cte1.catch_date AS catchDate, cte1.hc_id as healthCheckId, cte2.code, cte3.channel, b.status, b.comment\n" +
                "FROM BIRD AS b\n" +
                "         LEFT JOIN cte1\n" +
                "                   ON cte1.bird_id = b.id\n" +
                "         LEFT JOIN cte2\n" +
                "                   ON cte2.bird_id = b.id\n" +
                "         LEFT JOIN cte3\n" +
                "                   ON cte3.bird_id = b.id\n" +
                "         WHERE b.id=:id",
        resultSetMapping = "bird_extended_dto"
)

@NamedNativeQuery(
        // QUERY TO FIND 1 BIRD WITH NEWEST HEALTH CHECK, NEWWEST CHANNEL AND NEWEST PIT CODE
        // USE IN BASE BIRD VIEW DTO
        name = "find_bird_newest_hc_pit_trans",
        query = "WITH cte1 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT id AS hc_id, bird_id, catch_date\n" +
                "                  , ROW_NUMBER() OVER (PARTITION BY bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM HEALTH_CHECK\n" +
                "         ) AS cte1a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "   , cte2 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT p.id AS pit_id\n" +
                "                  , hc.bird_id\n" +
                "                  , p.Health_Check_Id\n" +
                "                  , p.code\n" +
                "                  , hc.catch_date as catchdate\n" +
                "                  , RANK() OVER (PARTITION BY hc.bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM PIT          AS p\n" +
                "                      JOIN HEALTH_CHECK AS hc\n" +
                "                           ON p.Health_Check_Id = hc.id\n" +
                "         ) AS cte2a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "   , cte3 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT t.id AS transmitter_id\n" +
                "                  , hc.bird_id\n" +
                "                  , t.Health_Check_Id\n" +
                "                  , t.channel\n" +
                "                  , hc.catch_date as catchdate\n" +
                "                  , RANK() OVER (PARTITION BY hc.bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM TRANSMITTER          AS t\n" +
                "                      JOIN HEALTH_CHECK AS hc\n" +
                "                           ON t.Health_Check_Id = hc.id\n" +
                "         ) AS cte3a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "SELECT b.id AS birdId, b.name, b.sex, cte1.catch_date AS catchDate, cte1.hc_id as healthCheckId, cte2.code, cte3.channel\n" +
                "FROM BIRD AS b\n" +
                "         LEFT JOIN cte1\n" +
                "                   ON cte1.bird_id = b.id\n" +
                "         LEFT JOIN cte2\n" +
                "                   ON cte2.bird_id = b.id\n" +
                "         LEFT JOIN cte3\n" +
                "                   ON cte3.bird_id = b.id\n" +
                "         WHERE b.id=:id",
        resultSetMapping = "bird_full_dto"
)

@NamedNativeQuery(
        // QUERY TO LIST BIRDS WITH NEWEST HEALTH CHECK, NEWWEST CHANNEL AND NEWEST PIT CODE - DASHBOARD
        name = "list_bird_newest_hc_pit_trans",
        query = "WITH cte1 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT id AS hc_id, bird_id, catch_date\n" +
                "                  , ROW_NUMBER() OVER (PARTITION BY bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM HEALTH_CHECK\n" +
                "         ) AS cte1a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "   , cte2 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT p.id AS pit_id\n" +
                "                  , hc.bird_id\n" +
                "                  , p.Health_Check_Id\n" +
                "                  , p.code\n" +
                "                  , hc.catch_date as catchdate\n" +
                "                  , RANK() OVER (PARTITION BY hc.bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM PIT          AS p\n" +
                "                      JOIN HEALTH_CHECK AS hc\n" +
                "                           ON p.Health_Check_Id = hc.id\n" +
                "         ) AS cte2a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "   , cte3 AS (\n" +
                "    SELECT *\n" +
                "    FROM (\n" +
                "             SELECT t.id AS transmitter_id\n" +
                "                  , hc.bird_id\n" +
                "                  , t.Health_Check_Id\n" +
                "                  , t.channel\n" +
                "                  , hc.catch_date as catchdate\n" +
                "                  , RANK() OVER (PARTITION BY hc.bird_id ORDER BY catch_date DESC) AS n\n" +
                "             FROM TRANSMITTER          AS t\n" +
                "                      JOIN HEALTH_CHECK AS hc\n" +
                "                           ON t.Health_Check_Id = hc.id\n" +
                "         ) AS cte3a\n" +
                "    WHERE n = 1\n" +
                ")\n" +
                "SELECT b.id AS birdId, b.name, b.sex, cte1.catch_date AS catchDate, cte1.hc_id as healthCheckId, cte2.code, cte3.channel\n" +
                "FROM BIRD AS b\n" +
                "         LEFT JOIN cte1\n" +
                "                   ON cte1.bird_id = b.id\n" +
                "         LEFT JOIN cte2\n" +
                "                   ON cte2.bird_id = b.id\n" +
                "         LEFT JOIN cte3\n" +
                "                   ON cte3.bird_id = b.id\n" +
                ";",
        resultSetMapping = "bird_full_dto"
)

@SqlResultSetMapping(
        name = "bird_full_dto",
        classes = @ConstructorResult(
                targetClass = BirdDTO.class,
                columns = {
                        @ColumnResult(name = "birdId", type = Long.class),
                        @ColumnResult(name = "healthCheckId", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "sex", type = String.class),
                        @ColumnResult(name = "catchDate", type = LocalDate.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "channel", type = Integer.class)
                }
        )
)

// RESULT SET MAPPING FOR BIRD FULL WITH EXTENDED FIELDS
@SqlResultSetMapping(
        name = "bird_extended_dto",
        classes = @ConstructorResult(
                targetClass = BirdViewDTO.class,
                columns = {
                        @ColumnResult(name = "birdId", type = Long.class),
                        @ColumnResult(name = "healthCheckId", type = Long.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "sex", type = String.class),
                        @ColumnResult(name = "catchDate", type = LocalDate.class),
                        @ColumnResult(name = "code", type = String.class),
                        @ColumnResult(name = "channel", type = Integer.class),
                        @ColumnResult(name = "status", type = String.class),
                        @ColumnResult(name = "comment", type = String.class)
                }
        )
)

public class Bird {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Name must not be null or empty")
    private String name;
    @Enumerated(EnumType.STRING)
    private BirdStatus status;
    private LocalDate dateDeceased;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private Taxa taxa;
    @Lob
    private String comment;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bird")
    private List<HealthCheck> listHealthCheck = new ArrayList<>();

    public Bird addHealthCheck(HealthCheck healthCheck) {
        listHealthCheck.add(healthCheck);
        healthCheck.setBird(this);
        return this;
    }

    public Bird removeHealthCheck(HealthCheck healthCheck) {
        listHealthCheck.remove(healthCheck);
        healthCheck.setBird(null);
        return this;
    }
}