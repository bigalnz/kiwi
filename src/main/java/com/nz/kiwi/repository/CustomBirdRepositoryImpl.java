package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdDetailsDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomBirdRepositoryImpl implements CustomBirdRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Object customQuery(Long id) {
        return entityManager.createQuery(
                        "SELECT MAX(h.catchDateTime), AVG(l.beakLength), AVG(l.tarsusLength),  AVG(l.tarsusWidth), b.name, b.id, weight_date, avg_weight FROM LengthMeasurements l " +
                                "JOIN l.healthCheck h " +
                                "JOIN h.bird b " +
                                "LEFT JOIN(SELECT MAX(w.healthCheck.catchDateTime) AS weight_date, AVG(w.weight) AS avg_weight, w.healthCheck.bird.id as bid FROM WeightMeasurements w WHERE w.healthCheck.bird.id=:id) AS x " +
                                "ON b.id = x.bid " +
                                "WHERE b.id=:id " +
                                "GROUP BY b.id, h.id ORDER BY l.healthCheck.catchDateTime DESC LIMIT 1")
                .setParameter("id", id)
                .getSingleResult();
    }
}
