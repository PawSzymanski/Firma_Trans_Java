package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Kurs")
@Setter
@Getter
public class RoadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs_sequence")
    @SequenceGenerator(name = "kurs_sequence", allocationSize = 1)
    @Column(name = "kur_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "kur_data")
    private LocalDate roadDate;

    @Column(name = "poj_pojazd")
    private String vehicle;

    @Column(name = "kie_kierowca")
    private String driver;

    @ManyToOne(fetch = FetchType.EAGER)
    private RoadPartEntity roadPart;
}