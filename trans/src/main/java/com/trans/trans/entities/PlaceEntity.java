package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "miejsce")
@Setter
@Getter
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miejsce_sequence")
    @SequenceGenerator(name = "miejsce_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "mie_number")
    int number;

    @Column(name = "mie_umiejscowienie")
    String place;

    @Column(name = "poj_pojazd")
    String vehicle;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "mie_na_rez",
            joinColumns = { @JoinColumn(name = "mie_miejsce") },
            inverseJoinColumns = { @JoinColumn(name = "rez_rezerwacja") }
    )
    List<ReservationEntity> reservation;
}
