package com.trans.trans.controllers;

import com.trans.trans.entities.ClientEntity;
import com.trans.trans.entities.RoleEntity;
import com.trans.trans.entities.VehicleEntity;
import com.trans.trans.jpa.ClientsJpa;
import com.trans.trans.jpa.RoleJpa;
import com.trans.trans.jpa.VehicleJpa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/clients")
public class ClientController {

    private ClientsJpa clientsJpa;

    private RoleJpa roleJpa;

    public ClientController(ClientsJpa clientsJpa) {
        this.clientsJpa = clientsJpa;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientEntity>> all(){
        return ResponseEntity.ok(clientsJpa.findAll());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<RoleEntity>> getRolesByUserId(@RequestParam String userId){
        return ResponseEntity.ok(roleJpa.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<ClientEntity> add(@RequestBody ClientEntity client){
        clientsJpa.save(client);
        return ResponseEntity.ok(client);
    }

}
