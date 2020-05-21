package com.trans.trans.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role")
@Setter
@Getter
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @SequenceGenerator(name = "role_sequence", allocationSize = 1)
    @Column(name = "rol_id", updatable = false, nullable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "kli_na_rol",
            joinColumns = { @JoinColumn(name = "rol_role") },
            inverseJoinColumns = { @JoinColumn(name = "kli_klient") }
    )
    @Column(name = "rol_klient_id")
    private List<ClientEntity> userId;

    @Column(name = "rol_rola")
    private String location;
}