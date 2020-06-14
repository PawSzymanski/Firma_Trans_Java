package com.trans.trans.controllers;

import com.trans.trans.entities.ClientEntity;
import com.trans.trans.entities.PointsEntity;
import com.trans.trans.jpa.PointsJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/points")
public class PointsController {

    private static PointsJpa pointsJpa;

    public PointsController(PointsJpa pointsJpa) {
        this.pointsJpa = pointsJpa;
    }

    @GetMapping("/get/{userName}")
    public ResponseEntity<PointsEntity> getPoints(@PathVariable String userName){
        return ResponseEntity.ok(pointsJpa.findByLogin(userName));
    }

    @PostMapping("/add")
    public ResponseEntity<PointsEntity> addPoints(@RequestBody PointsEntity points){
        points.setLogin(points.getLogin());
        points.setPoints(points.getPoints()+100);
        pointsJpa.save(points);
        return ResponseEntity.ok(points);
    }

    @PostMapping("/use")
    public ResponseEntity<PointsEntity> usePoints(@RequestBody PointsEntity points){
        if (points.getPoints()<500){return new ResponseEntity("Not enaught points", HttpStatus.FORBIDDEN);}
        else points.setPoints(points.getPoints() - 500);
        pointsJpa.save(points);
        return ResponseEntity.ok(points);
    }

    public static ResponseEntity<PointsEntity> createWithUser(@RequestBody ClientEntity client){
        PointsEntity pointsEntity = new PointsEntity();
        pointsEntity.setLogin(client.getLogin());
        pointsEntity.setPoints(0);
        pointsJpa.save(pointsEntity);
        return ResponseEntity.ok(pointsEntity);
    }
}
