package com.trans.trans.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
public class NewTripDto implements Serializable {

    private LocalDate roadDate;

    private String vehicle;

    private String driver;

    private Long roadPartId;
}
