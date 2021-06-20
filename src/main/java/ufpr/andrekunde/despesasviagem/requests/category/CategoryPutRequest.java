package ufpr.andrekunde.despesasviagem.requests.category;

import lombok.Data;

@Data
public class CategoryPutRequest {

    private Long id;
    private String description;
}
