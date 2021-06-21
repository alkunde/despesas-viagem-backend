package ufpr.andrekunde.despesasviagem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ufpr.andrekunde.despesasviagem.domain.Category;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPostRequest;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPutRequest;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategory(CategoryPostRequest categoryPostRequest);

    Category toCategory(CategoryPutRequest categoryPutRequest);
}
