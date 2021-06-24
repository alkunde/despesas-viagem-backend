package ufpr.andrekunde.despesasviagem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufpr.andrekunde.despesasviagem.domain.Category;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPostRequest;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPutRequest;
import ufpr.andrekunde.despesasviagem.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(categoryService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable long id) {
        return ResponseEntity.ok(categoryService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody CategoryPostRequest categoryPostRequest) {
        return new ResponseEntity<>(categoryService.save(categoryPostRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        categoryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CategoryPutRequest categoryPutRequest) {
        categoryService.replace(categoryPutRequest);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
