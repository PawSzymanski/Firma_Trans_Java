package com.trans.trans.jpa;

import com.trans.trans.entities.RoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoadJpa extends JpaRepository<RoadEntity, Long> {

    Optional<RoadEntity> findById(Long id);

}