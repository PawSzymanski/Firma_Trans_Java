package com.trans.trans.jpa;

import com.trans.trans.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationJpa  extends JpaRepository<ReservationEntity, Long> {

    List<ReservationEntity> findAllByClientName(String clientName);
}
