package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ufpr.andrekunde.despesasviagem.domain.Expense;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long id);

    List<Expense> findByTravelId(Long id);

    @Query(value = "SELECT * FROM expense WHERE travel_id IS NULL", nativeQuery = true)
    List<Expense> findWithoutTravel();
}
