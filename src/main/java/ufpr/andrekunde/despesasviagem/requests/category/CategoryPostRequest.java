package ufpr.andrekunde.despesasviagem.requests.category;

public class CategoryPostRequest {

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
