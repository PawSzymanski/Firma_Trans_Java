package com.trans.trans.jpa;

import com.trans.trans.entities.RoadPartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoadPartJpa extends JpaRepository<RoadPartEntity, Long> {

    List<RoadPartEntity> findAllByStartStop_NameLikeAndEndStop_NameLike(String start, String stop);
}
