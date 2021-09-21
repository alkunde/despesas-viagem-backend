package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateCategoryDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Category;
import br.ufpr.andrekunde.travelexpenses.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesRepository repository;

    @GetMapping
    public List<Category> list() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CreateCategoryDTO createCategoryDTO) {
        String description = createCategoryDTO.getDescription();

        Optional<Category> categoryExistent = repository.findByDescription(description);

        if (categoryExistent.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Category category = new Category(createCategoryDTO.getDescription());
        repository.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }
}