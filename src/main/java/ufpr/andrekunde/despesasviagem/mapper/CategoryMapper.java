package ufpr.andrekunde.despesasviagem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ufpr.andrekunde.despesasviagem.domain.Category;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPostRequest;
import ufpr.andrekunde.despesasviagem.requests.category.CategoryPutRequest;

@Mapper
public abstract class CategoryMapper {

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    public abstract Category toCategory(CategoryPostRequest categoryPostRequest);

    public abstract Category toCategory(CategoryPutRequest categoryPutRequest);
}
