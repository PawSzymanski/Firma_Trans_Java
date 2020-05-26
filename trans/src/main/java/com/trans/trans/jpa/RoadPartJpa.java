package com.trans.trans.jpa;

import com.trans.trans.entities.RoadPartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoadPartJpa extends JpaRepository<RoadPartEntity, Long> {

    Optional<RoadPartEntity> findById(Long id);

}
