package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Przystanek")
@Setter
@Getter
public class StopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "przystanek_sequence")
    @SequenceGenerator(name = "przystanek_sequence", allocationSize = 1)
    @Column(name = "prz_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "prz_name")
    private String name;

    @Column(name = "prz_lokalizacja")
    private String location;

    @Column(name = "prz_wspolrzendne")
    private String coordinates;
}
