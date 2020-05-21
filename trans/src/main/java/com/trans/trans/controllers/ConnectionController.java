package com.trans.trans.controllers;

import com.trans.trans.entities.RoadPartEntity;
import com.trans.trans.jpa.RoadPartJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/connection")
public class ConnectionController {

    private RoadPartJpa roadPartJpa;

    public ConnectionController(RoadPartJpa roadPartJpa) {
        this.roadPartJpa = roadPartJpa;
    }

    @GetMapping("/{start}/to/{end}")
    public ResponseEntity<List<RoadPartEntity>> getById(@PathVariable String start, @PathVariable String end) {
        return ResponseEntity.ok(roadPartJpa.findAllByStartStop_NameContainingAndEndStop_NameContaining(start, end));
    }
}
