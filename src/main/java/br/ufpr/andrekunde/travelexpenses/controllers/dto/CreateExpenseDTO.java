package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import br.ufpr.andrekunde.travelexpenses.entities.Category;
import br.ufpr.andrekunde.travelexpenses.entities.Users;

public class CreateExpenseDTO {

    private Double amount;
    private String description;
    private Category category;
    private Users user;

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public Users getUser() {
        return user;
    }
}
