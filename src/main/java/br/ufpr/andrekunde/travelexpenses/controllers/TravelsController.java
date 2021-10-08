package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateTravelDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import br.ufpr.andrekunde.travelexpenses.repositories.TravelsRepository;
import br.ufpr.andrekunde.travelexpenses.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travels")
public class TravelsController {

    @Autowired
    private TravelsRepository travelsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public ResponseEntity<List<Travel>> list() {
        return ResponseEntity.ok(travelsRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Travel>> listByUser(@PathVariable Long id) {
        Optional<Users> user = usersRepository.findById(id);

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(travelsRepository.findByUser(user.get()));
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

        travelsRepository.save(travel);

        return ResponseEntity.ok(travel);
    }

    @PatchMapping("/{id}/approval")
    public ResponseEntity<Travel> travelToApproval(@PathVariable Long id) {
        Optional<Travel> travelExistent = travelsRepository.findById(id);

        if (!travelExistent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Travel travel = travelExistent.get();
        travel.setStatus("em aprovação");

        travelsRepository.save(travel);

        return ResponseEntity.ok(travel);
    }

    @PatchMapping("/{id}/reprove")
    public ResponseEntity<Travel> reproveTravel(@PathVariable Long id) {
        Optional<Travel> travelExistent = travelsRepository.findById(id);

        if (!travelExistent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Travel travel = travelExistent.get();
        travel.setStatus("reprovado");

        travelsRepository.save(travel);

        return ResponseEntity.ok(travel);
    }

    @PatchMapping("/{id}/approve")
    public ResponseEntity<Travel> tapproveTravel(@PathVariable Long id) {
        Optional<Travel> travelExistent = travelsRepository.findById(id);

        if (!travelExistent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Travel travel = travelExistent.get();
        travel.setStatus("aprovado");

        travelsRepository.save(travel);

        return ResponseEntity.ok(travel);
    }
}
