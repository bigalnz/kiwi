package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdDetailsDto;
import com.nz.kiwi.view.BirdSummaryDto;
import com.nz.kiwi.view.HealthCheckDto;
import com.nz.kiwi.view.Test;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomBirdRepositoryImpl implements CustomBirdRepository {

    @PersistenceContext
    private EntityManager entityManager;


    /*
     *  Query to retrieve Bird Dto with details
     * TO DO:
     * Add bird.id to query and dto
     * Add healthcheck id for Lengths and Weights
     *
     * Check query is returning correct values -
     *
     * Add chick timer / relationship to all of above - will need same test data in db
     *
     *
     * */
    @Override
    public BirdDetailsDto customQuery(Long id) {
        return (BirdDetailsDto) entityManager.createQuery(
                        "SELECT NEW com.nz.kiwi.view.BirdDetailsDto(" +
                                "b.id, b.name, b.sex, b.status, b.currentTransmitter, b.currentPit," +
                                "NEW com.nz.kiwi.view.LengthMeasurementsDto(MAX(h.catchDateTime), AVG(l.beakLength), AVG(l.tarsusLength),  AVG(l.tarsusWidth), AVG(l.tarsusDepth))," +
                                "NEW com.nz.kiwi.view.WeightMeasurementsDto(MAX(x.weightCheckDate), AVG(x.weight))" +
                                ") " +
                                "FROM LengthMeasurements l " +
                                "JOIN l.healthCheck h " +
                                "JOIN h.bird b " +
                                "LEFT JOIN(SELECT MAX(w.healthCheck.catchDateTime) AS weightCheckDate, AVG(w.weight) AS weight, w.healthCheck.bird.id as bid FROM WeightMeasurements w WHERE w.healthCheck.bird.id=:id) AS x " +
                                "ON b.id = x.bid " +
                                "WHERE b.id=:id GROUP BY b.id, h.id ORDER BY l.healthCheck.catchDateTime DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public BirdSummaryDto customQuery2(Long id) {
        return (BirdSummaryDto) entityManager.createQuery(
                        "SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.id, b.name, b.sex, b.status, t.channel, t.tuning, p.code) FROM Bird b " +
                                "LEFT JOIN b.currentTransmitter t " +
                                "LEFT JOIN b.currentPit p " +
                                "WHERE b.id=:id GROUP BY b.id ORDER BY b.id DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public BirdSummaryDto customQuery1(Long id) {
        return (BirdSummaryDto) entityManager.createQuery(
                        "SELECT NEW com.nz.kiwi.view.BirdSummaryDto(b.id, b.name, b.sex, b.status, b.currentTransmitter.channel, b.currentTransmitter.tuning, b.currentPit.code) " +
                                "FROM Bird b " +
                                "WHERE b.id=:id GROUP BY b.id ORDER BY b.id DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Test customQuery3(Long id) {
        return (Test) entityManager.createQuery(
                        "SELECT NEW com.nz.kiwi.view.Test(b.id, b.name, hc) FROM Bird b " +
                                "LEFT JOIN b.listHealthCheck hc " +
                                "WHERE b.id=:id " +
                                "GROUP BY b, hc ORDER BY hc.catchDateTime DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Object customQuery4(Long id) {
        return (Object) entityManager.createQuery(
                        "SELECT NEW com.nz.kiwi.view.Test(b.id, b.name, " +
                                "NEW com.nz.kiwi.view.HealthCheckDto(hc.id, hc.catchDateTime, hc.releaseDateTime, hc.location)) FROM Bird b " +
                                "LEFT JOIN HealthCheck hc ON hc.bird.id=b.id " +
                                "WHERE b.id=:id " +
                                "GROUP BY b, hc ORDER BY hc.catchDateTime DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public HealthCheckDto customQuery5(Long id) {
        return (HealthCheckDto) entityManager.createQuery(
                        "SELECT NEW com.nz.kiwi.view.HealthCheckDto(hc.id, hc.catchDateTime, hc.releaseDateTime, hc.location) FROM HealthCheck hc " +
                                "WHERE hc.id=:id " +
                                "GROUP BY hc ORDER BY hc.catchDateTime DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }


}
