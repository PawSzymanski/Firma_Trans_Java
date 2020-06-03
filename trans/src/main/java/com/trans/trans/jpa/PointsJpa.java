package com.trans.trans.jpa;

import com.trans.trans.entities.ClientEntity;
import com.trans.trans.entities.PointsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsJpa extends JpaRepository<PointsEntity, Long> {

    PointsEntity findByLogin(String login);

}
