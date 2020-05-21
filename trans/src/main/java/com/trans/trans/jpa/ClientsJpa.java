package com.trans.trans.jpa;

import com.trans.trans.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsJpa extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByLogin(String login);
}
