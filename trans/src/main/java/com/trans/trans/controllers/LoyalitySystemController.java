package com.trans.trans.controllers;

import com.trans.trans.entities.LoyalitySystemEntity;
import com.trans.trans.jpa.LoyalitySystemJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/loyality")
public class LoyalitySystemController {

    private LoyalitySystemJpa loyalitySystemJpa;

    public LoyalitySystemController(LoyalitySystemJpa loyalitySystem){ this.loyalitySystemJpa = loyalitySystem;}

    @GetMapping("/getpoints/{id}")
    public ResponseEntity<LoyalitySystemEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok(loyalitySystemJpa.findById(id).get());
    }

    @PostMapping("/addpoints")
    public ResponseEntity<LoyalitySystemEntity> add(@RequestBody LoyalitySystemEntity loyalitySystem){
        loyalitySystemJpa.save(loyalitySystem);
        return ResponseEntity.ok(loyalitySystem);
    }
}
