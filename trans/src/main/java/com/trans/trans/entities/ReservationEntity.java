package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rezerwacja")
@Setter
@Getter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezerwacja_sequence")
    @SequenceGenerator(name = "rezerwacja_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "rez_status")
    String reservationStatus;

    @Column(name = "kli_klient")
    String clientName;

    @Column(name = "kur_kurs")
    int roadId;

    @Column(name = "odc_odcinek")
    int routeSectionId;
}
