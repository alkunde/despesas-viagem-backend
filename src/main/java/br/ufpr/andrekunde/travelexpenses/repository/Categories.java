package br.ufpr.andrekunde.travelexpenses.repository;

import br.ufpr.andrekunde.travelexpenses.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Categories extends JpaRepository<Category, Long> {
}
