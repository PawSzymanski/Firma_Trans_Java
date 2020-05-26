package com.trans.trans.controllers;

import com.trans.trans.entities.RoadEntity;
import com.trans.trans.entities.RoadPartEntity;
import com.trans.trans.jpa.RoadPartJpa;
import com.trans.trans.jpa.TripJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/connection")
public class ConnectionController {

    private TripJpa tripJpa;

    public ConnectionController(TripJpa tripJpa) {
        this.tripJpa = tripJpa;
    }

    @GetMapping("/{start}/to/{end}")
    public ResponseEntity<List<RoadEntity>> getById(@PathVariable String start, @PathVariable String end) {
        return ResponseEntity.ok(tripJpa.findAllByStartStop(start, end));
    }

    @PostMapping("/add")
    public ResponseEntity<RoadEntity> addTrip(@RequestBody RoadEntity r) {
        return ResponseEntity.ok(tripJpa.save(r));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoadEntity>> all() {
        return ResponseEntity.ok(tripJpa.findAll());
    }
}
