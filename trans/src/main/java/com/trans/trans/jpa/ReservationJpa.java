package com.trans.trans.jpa;

import com.trans.trans.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpa  extends JpaRepository<ReservationEntity, Long> {
}
