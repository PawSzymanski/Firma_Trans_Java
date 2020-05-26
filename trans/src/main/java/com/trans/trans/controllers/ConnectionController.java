package com.trans.trans.controllers;

import com.trans.trans.dto.NewTripDto;
import com.trans.trans.entities.RoadEntity;
import com.trans.trans.entities.RoadPartEntity;
import com.trans.trans.jpa.RoadPartJpa;
import com.trans.trans.jpa.TripJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/connection")
public class ConnectionController {

    private TripJpa tripJpa;

    private RoadPartJpa roadPartJpa;

    public ConnectionController(TripJpa tripJpa, RoadPartJpa roadPartJpa) {
        this.tripJpa = tripJpa;
        this.roadPartJpa = roadPartJpa;
    }

    @GetMapping("/{start}/to/{end}")
    public ResponseEntity<List<RoadEntity>> getById(@PathVariable String start, @PathVariable String end) {
        return ResponseEntity.ok(tripJpa.findAllByStartStop(start, end));
    }

    @PostMapping("/add")
    public ResponseEntity<RoadEntity> addTrip(@RequestBody NewTripDto t) {
        RoadEntity roadEntity = new RoadEntity();
        roadEntity.setRoadDate(t.getRoadDate());
        roadEntity.setDriver(t.getDriver());
        roadEntity.setRoadPart(roadPartJpa.findById(t.getRoadPartId()).get());
        roadEntity.setVehicle(t.getVehicle());
        tripJpa.save(roadEntity);
        return new ResponseEntity("jest gitez", HttpStatus.CREATED);
    }

    @GetMapping("/allTrips")
    public ResponseEntity<List<RoadEntity>> allTrips() {
        return ResponseEntity.ok(tripJpa.findAll());
    }

    @GetMapping("/allConnections")
    public ResponseEntity<List<RoadPartEntity>> allConn() {
        return ResponseEntity.ok(roadPartJpa.findAll());
    }
}
