package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelsController {

    @Autowired
    private TravelsRepository repository;

    @GetMapping
    public List<Travel> find() {
        return repository.findAll();
    }
}
