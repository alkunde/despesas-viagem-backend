package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.Expense;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long id);
}
