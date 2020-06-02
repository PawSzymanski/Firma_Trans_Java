package com.trans.trans.controllers;

import com.trans.trans.dto.LoginDto;
import com.trans.trans.entities.ClientEntity;
import com.trans.trans.entities.ReservationEntity;
import com.trans.trans.entities.RoadPartEntity;
import com.trans.trans.entities.RoleEntity;
import com.trans.trans.jpa.ClientsJpa;
import com.trans.trans.jpa.ReservationJpa;
import com.trans.trans.jpa.RoleJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/clients")
public class ClientController {

    private ClientsJpa clientsJpa;

    private RoleJpa roleJpa;

  //  private ReservationJpa;

    public ClientController(ClientsJpa clientsJpa, RoleJpa roleJpa) {
        this.clientsJpa = clientsJpa;
        this.roleJpa = roleJpa;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientEntity>> all() {
        return ResponseEntity.ok(clientsJpa.findAll());
    }

    @GetMapping("/roles/{userId}")
    public ResponseEntity<List<RoleEntity>> getRolesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(roleJpa.findAllByUser(userId));
    }

    @GetMapping("/getpoints/{clientName}")
    public ResponseEntity<ClientEntity> getPoinst(@PathVariable String clientName){
        return ResponseEntity.ok(clientsJpa.findByLogin(clientName));
    }


    @PostMapping("/addpoints")
    public ResponseEntity<ClientEntity> addPoints(@RequestBody ClientEntity client){
        client.setPoints(client.getPoints() + 100);
        clientsJpa.save(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/usepoints")
    public ResponseEntity<ClientEntity> usePoints(@RequestBody ClientEntity client){
    //    ReservationController reservation = new ReservationController();
        if(client.getPoints()<500){
            return new ResponseEntity("not enaught points",HttpStatus.FORBIDDEN);
        }else{
            client.setPoints(client.getPoints() - 500);
 //           reservationEntity
        }
        clientsJpa.save(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/add")
    public ResponseEntity<ClientEntity> add(@RequestBody ClientEntity client) {

        if(client.getRole() == null) {
            RoleEntity r = roleJpa.findByRoleLike("User_Role");
            client.setRole(r);
        } else {
            client.setRole(roleJpa.findByRoleLike(client.getRole().getRole()));
        }
        clientsJpa.save(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/login")
    public ResponseEntity<ClientEntity> add(@RequestBody LoginDto loginDto) {
        ClientEntity client = clientsJpa.findByLogin(loginDto.getLogin());
        if (client == null) {
            return new ResponseEntity("no user in database", HttpStatus.FORBIDDEN);
        }
        if (client.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.ok(client);
        }
        return new ResponseEntity("bad password", HttpStatus.FORBIDDEN);
    }
}
