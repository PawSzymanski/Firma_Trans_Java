package com.trans.trans.controllers;

import com.trans.trans.dto.ReservationDto;
import com.trans.trans.entities.ClientEntity;
import com.trans.trans.entities.ReservationEntity;
import com.trans.trans.jpa.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationJpa reservationJpa;

    private RoadJpa roadJpa;

    private ClientsJpa clientsJpa;

    public ReservationController(ReservationJpa reservationJpa, RoadJpa roadJpa) {
        this.reservationJpa = reservationJpa;
        this.roadJpa = roadJpa;
    }

    @PostMapping("/make")
    public ResponseEntity<ReservationEntity> add(@RequestBody ReservationDto body) {
        ReservationEntity res = new ReservationEntity();
        res.setReservationStatus("UNPAID");
        res.setRoad(roadJpa.findById(body.getRoadId()).get());
        res.setClientName(body.getClientName());
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
