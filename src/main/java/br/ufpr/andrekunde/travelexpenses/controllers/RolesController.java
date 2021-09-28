package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.entities.Role;
import br.ufpr.andrekunde.travelexpenses.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesRepository repository;

    @GetMapping
    public ResponseEntity<List<Role>> list() {
        List<Role> roles = repository.findAll();

        return ResponseEntity.ok(roles);
    }
}
