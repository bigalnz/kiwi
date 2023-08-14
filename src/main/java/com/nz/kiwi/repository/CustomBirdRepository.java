package com.nz.kiwi.repository;

import com.nz.kiwi.view.BirdDetailsDto;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomBirdRepository {
    Object customQuery(Long id);
}
