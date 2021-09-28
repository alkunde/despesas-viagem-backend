package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateCategoryDTO;
import br.ufpr.andrekunde.travelexpenses.entities.Category;
import br.ufpr.andrekunde.travelexpenses.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<List<Category>> list() {
        return ResponseEntity.ok(repository.findAll(Sort.by(Sort.Direction.ASC, "description")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> find(@PathVariable Long id) {
        Optional<Category> category = repository.findById(id);

        return category.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/find/{description}")
    public ResponseEntity<Category> findByDescription(@PathVariable String description) {
        Optional<Category> category = repository.findByDescriptionIgnoreCase(description);

        return category.map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CreateCategoryDTO createCategoryDTO) {
        String description = createCategoryDTO.getDescription();

        Optional<Category> categoryExistent = repository.findByDescriptionIgnoreCase(description);

        if (categoryExistent.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Category category = new Category(createCategoryDTO.getDescription());
        repository.save(category);

        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category category) {
        Optional<Category> categoryExistent = repository.findByDescriptionIgnoreCase(category.getDescription());

        if (categoryExistent.isPresent()) {
            if (categoryExistent.get().getId().equals(category.getId())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }

        repository.save(category);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Category> category = repository.findById(id);

        if (!category.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
