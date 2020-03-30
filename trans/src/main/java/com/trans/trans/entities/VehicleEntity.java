package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pojazd")
@Setter
@Getter
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pojazd_sequence")
    @SequenceGenerator(name = "pojazd_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "poj_rejestracja")
    private String registration;

    @Column(name = "poj_parking")
    private String parking;

    @Column(name = "poj_stan")
    private String condition;

}
