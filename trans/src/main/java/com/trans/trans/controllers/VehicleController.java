package com.trans.trans.controllers;

import com.trans.trans.entities.VehicleEntity;
import com.trans.trans.jpa.VehicleJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/vehicle")
public class VehicleController {

    private VehicleJpa vehicleJpa;

    public VehicleController(VehicleJpa vehicleJpa) {
        this.vehicleJpa = vehicleJpa;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> getById(@PathVariable Long id){
            return ResponseEntity.ok(vehicleJpa.findById(id).get());
    }


}
