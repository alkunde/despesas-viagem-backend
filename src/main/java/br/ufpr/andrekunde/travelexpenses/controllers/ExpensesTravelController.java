package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.entities.Expense;
import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.repositories.ExpensesRepository;
import br.ufpr.andrekunde.travelexpenses.repositories.TravelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travel")
public class ExpensesTravelController {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private TravelsRepository travelsRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<Expense>> list(@PathVariable Long id) {
        Optional<Travel> travel = travelsRepository.findById(id);

        if (!travel.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expensesRepository.findByTravel(travel.get()));
    }
}
