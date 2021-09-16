package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.domain.Expense;
import ufpr.andrekunde.despesasviagem.domain.Travel;
import ufpr.andrekunde.despesasviagem.service.ExpenseService;
import ufpr.andrekunde.despesasviagem.service.TravelService;

@RestController
@RequestMapping("expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final TravelService travelService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(expenseService.listAll());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<?> listByUser(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.listAllByUser(id));
    }

    @GetMapping(path = "/travel/{id}")
    public ResponseEntity<?> listByTravel(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.listAllByTravel(id));
    }

    @GetMapping(path = "/no-travel")
    public ResponseEntity<?> listWithoutTravel() {
        return ResponseEntity.ok(expenseService.listWithoutTravel());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Expense> findById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Expense> save(@RequestBody Expense expense) {
        return new ResponseEntity<>(expenseService.save(expense), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        expenseService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> replace(@RequestBody Expense expense) {
        expenseService.replace(expense);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}/clear-travel")
    public ResponseEntity<?> clearTravel(@PathVariable Long id) {
//        Expense expense = expenseService.findByIdOrThrowBadRequestException(id);
//
//        if (!expense.getTravel().getStatus().equals("aberto")) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
        expenseService.clearTravel(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/travel/{travelId}")
    public ResponseEntity<?> expenseToTravel(
            @PathVariable Long id,
            @PathVariable Long travelId
    ) {
        Expense expense = expenseService.findByIdOrThrowBadRequestException(id);
        Travel travel = travelService.findByIdOrThrowBadRequestException(travelId);
        expense.setTravel(travel);

        expenseService.save(expense);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
