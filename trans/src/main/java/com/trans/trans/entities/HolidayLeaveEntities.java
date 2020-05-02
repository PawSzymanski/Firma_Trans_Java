package com.trans.trans.entities;

import jdk.vm.ci.meta.Local;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "urlop")
@Setter
@Getter
public class HolidayLeaveEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urlop_sequence")
    @SequenceGenerator(name = "urlop_sequence", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "url_od")
    LocalDate holidayLeaveFrom;

    @Column(name = "url_do")
    LocalDate holidayLeaveTo;

    @Column(name = "pra_pracownik")
    String login;
}
