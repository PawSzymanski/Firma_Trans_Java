package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Tankowanie")
@Setter
@Getter
public class RefuelingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tankowanie_sequence")
    @SequenceGenerator(name = "tankowanie_sequence", allocationSize = 1)
    @Column(name = "tan_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "tan_godz_odj")
    private LocalDate time;

    @Column(name = "tan_wsiadlo")
    private Long liters;

    @Column(name = "tan_wysiadlo")
    private Long km;

//    @ManyToOne(name = "tan_przystanek")
//    private VehicleEntity vehice;
//
//    @ManyToOne(name = "tan_kurs")
//    private VehicleEntity vehice;
}
