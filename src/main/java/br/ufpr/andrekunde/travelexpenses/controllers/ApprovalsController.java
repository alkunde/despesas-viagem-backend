package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/approvals")
public class ApprovalsController {

    @Autowired
    private TravelsRepository travelsRepository;

    @GetMapping
    public ResponseEntity<List<Travel>> list() {
        List<Travel> travels = travelsRepository.findByStatus("em aprovação");

        return ResponseEntity.ok(travels);
    }
}
