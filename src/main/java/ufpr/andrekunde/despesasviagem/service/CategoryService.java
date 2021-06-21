package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufpr.andrekunde.despesasviagem.domain.Category;
import ufpr.andrekunde.despesasviagem.mapper.CategoryMapper;
import ufpr.andrekunde.despesasviagem.repository.CategoryRepository;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPostRequest;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPutRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public List<Category> findByDescription(String description) {
        return categoryRepository.findByDescription(description);
    }

    public Category findByIdOrThrowBadRequestException(long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found")
                );
    }

    public Category save(CategoryPostRequest categoryPostRequest) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryPostRequest);

        return categoryRepository.save(category);
    }

    public void delete(long id) {
        categoryRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CategoryPutRequest categoryPutRequest) {
        Category categorySaved = findByIdOrThrowBadRequestException(categoryPutRequest.getId());

        Category category = CategoryMapper.INSTANCE.toCategory(categoryPutRequest);
        category.setId(categorySaved.getId());

        categoryRepository.save(category);
    }
}
