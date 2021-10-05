package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.Expense;
import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(Users user);

    List<Expense> findByTravel(Travel travel);

    @Query(value = "select * from expense where travel_id is null", nativeQuery = true)
    List<Expense> findWithoutTravel();
}
