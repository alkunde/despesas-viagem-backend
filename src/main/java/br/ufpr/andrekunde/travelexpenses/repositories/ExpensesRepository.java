package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.Expense;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(Users user);
}
