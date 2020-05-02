package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pracownik")
@Setter
@Getter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pracownik_sequence")
    @SequenceGenerator(name = "pracownik_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "pra_login", updatable = true, nullable = false)
    private String login;

    @Column(name = "pra_haslo", updatable = true, nullable = false)
    private String password;

    @Column(name = "pra_imie")
    private String name;

    @Column(name = "pra_nazwisko")
    private String lastName;

    @Column(name = "pra_data_urodzenia")
    private LocalDate birthDate;

    @Column(name = "pra_email")
    private String email;

    @Column(name = "pra_telefon")
    private int phoneNumber;

    @Column(name = "pra_stanowisko")
    private String employeePosition;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "poj_na_pra",
            joinColumns = { @JoinColumn(name = "pra_pracownik") },
            inverseJoinColumns = { @JoinColumn(name = "poj_pojazd") }
    )
    List<VehicleEntity> vehicle;
}
