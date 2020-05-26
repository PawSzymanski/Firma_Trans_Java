package com.trans.trans.jpa;

import com.trans.trans.entities.RoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripJpa extends JpaRepository<RoadEntity, Long> {
}
