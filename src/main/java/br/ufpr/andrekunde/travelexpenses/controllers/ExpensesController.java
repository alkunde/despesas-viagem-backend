package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateExpenseDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Expense;
import br.ufpr.andrekunde.travelexpenses.repositories.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesRepository repository;

    @GetMapping
    public List<Expense> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> find(@PathVariable Long id) {
        Optional<Expense> expense = repository.findById(id);

        return expense.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody CreateExpenseDTO createExpenseDTO) {
        Expense expense = new Expense(
                createExpenseDTO.getAmount(),
                createExpenseDTO.getDescription(),
                createExpenseDTO.getCategory()
        );

        repository.save(expense);

        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> update(
            @PathVariable Long id,
            @RequestBody CreateExpenseDTO createExpenseDTO
    ) {
        Optional<Expense> expenseExistent = repository.findById(id);

        if (!expenseExistent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Expense expense = expenseExistent.get();
        expense.setDescription(createExpenseDTO.getDescription());
        expense.setCategory(createExpenseDTO.getCategory());
        expense.setAmount(createExpenseDTO.getAmount());

        repository.save(expense);

        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Expense> expense = repository.findById(id);

        if (!expense.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
