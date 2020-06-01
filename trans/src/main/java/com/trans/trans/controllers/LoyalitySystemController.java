package com.trans.trans.controllers;

import com.trans.trans.entities.LoyalitySystemEntity;
import com.trans.trans.entities.ReservationEntity;
import com.trans.trans.jpa.LoyalitySystemJpa;
import com.trans.trans.jpa.ReservationJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/loyality")
public class LoyalitySystemController {

    private LoyalitySystemJpa loyalitySystemJpa;
    private ReservationJpa reservationJpa;

    public LoyalitySystemController(){}

    public LoyalitySystemController(LoyalitySystemJpa loyalitySystemJpa, ReservationJpa reservationJpa) {
        this.loyalitySystemJpa = loyalitySystemJpa;
        this.reservationJpa = reservationJpa;
    }

    public LoyalitySystemController(LoyalitySystemJpa loyalitySystem){ this.loyalitySystemJpa = loyalitySystem;}

    @GetMapping("/getpoints/{clientName}")
    public ResponseEntity<List<ReservationEntity>> getClientReservations(@PathVariable String clientName){
        return ResponseEntity.ok(reservationJpa.findAllByClientName(clientName));
    }

    @PostMapping("/addpoints")
    public ResponseEntity<LoyalitySystemEntity> add(@RequestBody LoyalitySystemEntity loyalitySystem){
        loyalitySystemJpa.save(loyalitySystem);
        return ResponseEntity.ok(loyalitySystem);
    }
}
