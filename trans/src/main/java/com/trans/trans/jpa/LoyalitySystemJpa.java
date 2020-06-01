package com.trans.trans.jpa;

import com.trans.trans.entities.LoyalitySystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoyalitySystemJpa extends JpaRepository<LoyalitySystemEntity, Long> {

    @Query("select r from LoyalitySystemEntity r inner join r.rewards u where u.id = r.reservationId ")
    List<LoyalitySystemEntity> findAllByUser(Long userId);
}
