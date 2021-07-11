package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ufpr.andrekunde.despesasviagem.domain.Expense;
import ufpr.andrekunde.despesasviagem.exception.BadRequestException;
import ufpr.andrekunde.despesasviagem.repository.ExpenseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public List<Expense> listAll() {
        return expenseRepository.findAll();
    }

    public List<Expense> listAllByUser(Long id) {
        return expenseRepository.findByUserId(id);
    }

    public Expense findByIdOrThrowBadRequestException(Long id) {
        return expenseRepository
                .findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Expense not found")
                );
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void delete(Long id) {
        expenseRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(Expense expense) {
        expenseRepository.save(expense);
    }
}
