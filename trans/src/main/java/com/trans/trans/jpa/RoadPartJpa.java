package com.trans.trans.jpa;

import com.trans.trans.entities.RoadEntity;
import com.trans.trans.entities.RoadPartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoadPartJpa extends JpaRepository<RoadPartEntity, Long> {


}
