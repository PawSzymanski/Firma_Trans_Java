package com.trans.trans.jpa;

import com.trans.trans.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleJpa extends JpaRepository<VehicleEntity, Long> {

    Optional<VehicleEntity> findById(Long id);
}
