package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
