package com.trans.trans.jpa;

import com.trans.trans.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleJpa  extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> getAllByUserId(Long userId);
}
