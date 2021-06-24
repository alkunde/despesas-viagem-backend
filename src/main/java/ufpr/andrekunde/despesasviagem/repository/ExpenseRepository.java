package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
