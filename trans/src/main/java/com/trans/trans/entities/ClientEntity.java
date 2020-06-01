package com.trans.trans.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Klient")
@Setter
@Getter
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "klient_sequence")
    @SequenceGenerator(name = "klient_sequence", allocationSize = 1)
    @Column(name = "kli_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "kli_login")
    private String login;

    @Column(name = "kli_haslo")
    private String password;

    @Column(name = "kli_imie")
    private String name;

    @Column(name = "kli_nazwisko")
    private String surname;

    @Column(name = "kli_data_ur")
    private LocalDate birthday;

    @Column(name = "kli_email")
    private String email;

    @Column(name = "kli_telefon")
    private String phone;

    @Column(name = "kli_blokada")
    private Boolean isBlocked;

    @Column(name = "kli_points")
    private int points;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "kli_na_zni",
            joinColumns = { @JoinColumn(name = "kli_klient") },
            inverseJoinColumns = { @JoinColumn(name = "zni_znizka") }
    )
    private List<DiscountEntity> discounts;

    @ManyToOne(fetch = FetchType.EAGER)
   /* @JoinTable(
            name = "kli_na_rol",
            joinColumns = { @JoinColumn(name = "kli_klient") },
            inverseJoinColumns = { @JoinColumn(name = "rol_role") }
    )*/
    private RoleEntity role;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "nag_na_kli",
            joinColumns = { @JoinColumn(name = "kli_klient") },
            inverseJoinColumns = { @JoinColumn(name = "zni_nagroda") }
    )
    private List<LoyalitySystemEntity> rewards;
}
