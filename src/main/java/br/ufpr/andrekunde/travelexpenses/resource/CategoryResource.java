package br.ufpr.andrekunde.travelexpenses.resource;

import br.ufpr.andrekunde.travelexpenses.model.Category;
import br.ufpr.andrekunde.travelexpenses.repository.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private Categories categories;

    @GetMapping
    public List<Category> list() {
        return categories.findAll();
    }

    @PostMapping
    public Category create(@Valid @RequestBody Category category) {
        return categories.save(category);
    }
}
