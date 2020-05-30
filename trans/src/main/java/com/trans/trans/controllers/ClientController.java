package com.trans.trans.controllers;

import com.trans.trans.dto.LoginDto;
import com.trans.trans.entities.ClientEntity;
import com.trans.trans.entities.RoleEntity;
import com.trans.trans.jpa.ClientsJpa;
import com.trans.trans.jpa.RoleJpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/clients")
public class ClientController {

    private ClientsJpa clientsJpa;

    private RoleJpa roleJpa;

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

    @PostMapping("/add")
    public ResponseEntity<ClientEntity> add(@RequestBody ClientEntity client) {
        RoleEntity r = roleJpa.findByRoleLike("User_Role");
        List<RoleEntity> rs = new ArrayList<>();
        rs.add(r);
        client.setRoles(rs);
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
