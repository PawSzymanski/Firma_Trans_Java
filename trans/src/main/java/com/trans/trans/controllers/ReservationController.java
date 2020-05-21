package com.trans.trans.controllers;

import com.trans.trans.dto.ReservationDto;
import com.trans.trans.entities.ReservationEntity;
import com.trans.trans.entities.RoadEntity;
import com.trans.trans.jpa.ReservationJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationJpa reservationJpa;

    public ReservationController(ReservationJpa reservationJpa) {
        this.reservationJpa = reservationJpa;
    }

    @PostMapping("/make")
    public ResponseEntity<ReservationEntity> add(@RequestBody ReservationEntity res) {
        res.setReservationStatus("UNPAID");
        reservationJpa.save(res);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<ReservationEntity>> add(@PathVariable String userName) {
        reservationJpa.findAllByClientName(userName);
        return ResponseEntity.ok(reservationJpa.findAllByClientName(userName));
    }


    @GetMapping("/all")
    public ResponseEntity<List<ReservationEntity>> all() {
        return ResponseEntity.ok(reservationJpa.findAll());
    }

}
