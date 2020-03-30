package com.trans.trans.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class VehicleDao {

    @Autowired
    private EntityManager entityManager;

}
