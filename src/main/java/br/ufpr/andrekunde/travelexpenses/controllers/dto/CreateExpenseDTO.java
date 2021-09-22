package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import br.ufpr.andrekunde.travelexpenses.entities.Category;

public class CreateExpenseDTO {

    private Double amount;
    private String description;
    private Category category;

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
