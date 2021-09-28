package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import br.ufpr.andrekunde.travelexpenses.entities.Category;
import br.ufpr.andrekunde.travelexpenses.entities.Users;

public class CreateExpenseDTO {

    private Double amount;
    private String description;
    private int year, month, day;
    private Category category;
    private Users user;

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public Category getCategory() {
        return category;
    }

    public Users getUser() {
        return user;
    }
}
