package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateTravelDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelsController {

    @Autowired
    private TravelsRepository repository;

    @GetMapping
    public ResponseEntity<List<Travel>> find() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Travel> create(@RequestBody CreateTravelDTO createTravelDTO) {
        Travel travel = new Travel(
                "aberto",
                createTravelDTO.getOrigin(),
                createTravelDTO.getDestination(),
                createTravelDTO.getAmount(),
                new Date(createTravelDTO.getDepartureYear() - 1900, createTravelDTO.getDepartureMonth() - 1, createTravelDTO.getDepartureDay()),
                new Date(createTravelDTO.getArrivalYear() - 1900, createTravelDTO.getArrivalMonth() - 1, createTravelDTO.getArrivalDay()),
                createTravelDTO.getReason(),
                createTravelDTO.getCostCenter(),
                createTravelDTO.getUser()
        );

        repository.save(travel);

        return ResponseEntity.ok(travel);
    }
}
