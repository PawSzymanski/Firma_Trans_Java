package com.trans.trans.controllers;

import com.trans.trans.dto.ReservationDto;
import com.trans.trans.entities.ReservationEntity;
import com.trans.trans.jpa.ReservationJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationJpa reservationJpa;

    public ReservationController(ReservationJpa reservationJpa) {
        this.reservationJpa = reservationJpa;
    }

    @PostMapping("/make")
    public ResponseEntity<ReservationEntity> add(@RequestBody ReservationDto client) {
        //reservationJpa.save(client);
        return ResponseEntity.ok(null);
    }

}
