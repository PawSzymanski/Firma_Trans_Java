package com.trans.trans.jpa;

import com.trans.trans.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleJpa  extends JpaRepository<RoleEntity, Long> {

    @Query("select r from RoleEntity r left outer join r.user u where u.id = ?1")
    List<RoleEntity> findAllByUser(Long userId);

    RoleEntity findByRoleLike(String role);
}
