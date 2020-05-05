package com.trans.trans.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Odcinek_Trasy")
@Setter
@Getter
public class RoadPartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odc_tr_sequence")
    @SequenceGenerator(name = "odc_tr_sequence", allocationSize = 1)
    @Column(name = "odc_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "odc_cena")
    private String price;

    @Column(name = "odc_odleglosc")
    private Double distance;

    @ManyToOne(fetch = FetchType.EAGER)
    private StopEntity endStop;

    @ManyToOne(fetch = FetchType.EAGER)
    private StopEntity startStop;

}
