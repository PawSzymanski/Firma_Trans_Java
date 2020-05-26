package com.trans.trans.jpa;

import com.trans.trans.entities.RoadEntity;
import com.trans.trans.entities.RoadPartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoadPartJpa extends JpaRepository<RoadPartEntity, Long> {

    @Query("select r from RoadEntity r left outer join r.roadPart u where u.startStop.name like %?1% and u.endStop.name like %?2%")
    List<RoadEntity> findAllByStartStop_NameContainingAndEndStop_NameContaining(String start, String stop);
}
