package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateExpenseDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Expense;
import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import br.ufpr.andrekunde.travelexpenses.repositories.ExpensesRepository;
import br.ufpr.andrekunde.travelexpenses.repositories.TravelsRepository;
import br.ufpr.andrekunde.travelexpenses.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private TravelsRepository travelsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public ResponseEntity<List<Expense>> list() {
        return ResponseEntity.ok(expensesRepository.findAll());
    }

    @GetMapping("/no-travel")
    public ResponseEntity<List<Expense>> listWithoutTravel() {
        return ResponseEntity.ok(expensesRepository.findWithoutTravel());
    }

    @GetMapping("/travel/{travelId}")
    public ResponseEntity<List<Expense>> listByTravel(@PathVariable Long travelId) {
        Optional<Travel> travel = travelsRepository.findById(travelId);

        if (!travel.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<Expense> expenses = expensesRepository.findByTravel(travel.get());

        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Expense>> listByUser(@PathVariable Long id) {
        Optional<Users> user = usersRepository.findById(id);

        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(expensesRepository.findByUser(user.get()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> find(@PathVariable Long id) {
        Optional<Expense> expense = expensesRepository.findById(id);

        return expense.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{expenseId}/clear-travel")
    public ResponseEntity<?> removeTravelFromExpense(@PathVariable Long expenseId) {
        Optional<Expense> expense = expensesRepository.findById(expenseId);

        if (!expense.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Expense expenseExistent = expense.get();
        expenseExistent.setTravel(null);
        expensesRepository.save(expenseExistent);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{expenseId}/travel/{travelId}")
    public ResponseEntity<?> addTravelToExpense(
            @PathVariable Long expenseId,
            @PathVariable Long travelId
    ) {
        Optional<Travel> travel = travelsRepository.findById(travelId);

        if (!travel.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Optional<Expense> expense = expensesRepository.findById(expenseId);

        if (!expense.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Expense newExpense = expense.get();
        newExpense.setTravel(travel.get());
        expensesRepository.save(newExpense);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody CreateExpenseDTO createExpenseDTO) {
        Expense expense = new Expense(
                createExpenseDTO.getAmount(),
                createExpenseDTO.getDescription(),
                new Date(createExpenseDTO.getYear() - 1900, createExpenseDTO.getMonth() - 1, createExpenseDTO.getDay()),
                createExpenseDTO.getCategory(),
                createExpenseDTO.getUser()
        );

        expensesRepository.save(expense);

        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> update(
            @PathVariable Long id,
            @RequestBody CreateExpenseDTO createExpenseDTO
    ) {
        Optional<Expense> expenseExistent = expensesRepository.findById(id);

        if (!expenseExistent.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Expense expense = expenseExistent.get();
        expense.setDescription(createExpenseDTO.getDescription());
        expense.setAmount(createExpenseDTO.getAmount());
        expense.setCategory(createExpenseDTO.getCategory());
        expense.setExpenseDate(
                new Date(
                        createExpenseDTO.getYear() - 1900,
                        createExpenseDTO.getMonth() - 1,
                        createExpenseDTO.getDay()
                )
        );

        expensesRepository.save(expense);

        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Expense> expense = expensesRepository.findById(id);

        if (!expense.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        expensesRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
