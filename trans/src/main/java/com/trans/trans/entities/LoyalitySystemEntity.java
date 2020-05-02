package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "nagroda")
@Setter
@Getter
public class LoyalitySystemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nagroda_sequence")
    @SequenceGenerator(name = "nagroda_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "nag_punktow")
    int loyalitySystemPoints;

    @Column(name = "rez_rezerwacja")
    int reservationId;

    @Column(name = "zni_znizka")
    int discountId;
}
