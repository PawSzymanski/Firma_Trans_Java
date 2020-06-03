package com.trans.trans.entities;

import com.trans.trans.controllers.PointsController;
import com.trans.trans.jpa.PointsJpa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Punkty")
@Setter
@Getter
public class PointsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "points_seq")
    @SequenceGenerator(name = "points_seq", allocationSize = 1)
    @Column(name = "kli_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "kli_login")
    private String login;

    @Column(name = "pkt_ilosc")
    private int points;

    public void createWithUser(ClientEntity clientEntity){
        PointsController.createWithUser(clientEntity);
    }
}
