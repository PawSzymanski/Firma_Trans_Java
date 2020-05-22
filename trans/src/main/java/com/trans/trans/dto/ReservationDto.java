package com.trans.trans.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ReservationDto implements Serializable {

    private Long roadId;

    private String clientName;
}
