package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.domain.Expense;
import ufpr.andrekunde.despesasviagem.service.ExpenseService;

@RestController
@RequestMapping("expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(expenseService.listAll());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<?> listByUser(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.listAllByUser(id));
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
}
