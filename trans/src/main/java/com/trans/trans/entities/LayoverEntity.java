package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Postoj")
@Setter
@Getter
public class LayoverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postoj_sequence")
    @SequenceGenerator(name = "postoj_sequence", allocationSize = 1)
    @Column(name = "pos_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "pos_czas")
    private LocalDate time;

    @Column(name = "pos_litrow")
    private Long liters;

    @Column(name = "pos_km")
    private String km;
}
