package ufpr.andrekunde.despesasviagem.requests.category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryPostRequest {

    @NotEmpty(message = "Description cannot be empty")
    @NotNull(message = "Description cannot be null")
    private String description;

    public CategoryPostRequest() {
    }

    public CategoryPostRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
