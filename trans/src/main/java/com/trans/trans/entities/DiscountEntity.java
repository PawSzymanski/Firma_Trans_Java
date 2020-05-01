package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Znizka")
@Setter
@Getter
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "znizka_sequence")
    @SequenceGenerator(name = "znizka_sequence", allocationSize = 1)
    @Column(name = "zni_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "zni_znizka")
    private Float discount;

    @Column(name = "zni_opis")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    List<ClientEntity> client;
}
