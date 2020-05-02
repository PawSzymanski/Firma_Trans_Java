package com.trans.trans.jpa;

import com.trans.trans.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsJpa extends JpaRepository<ClientEntity, Long> {
}
