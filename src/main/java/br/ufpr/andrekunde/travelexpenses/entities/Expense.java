package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(scale = 2, precision = 10)
    private Double amount;

    private String description;

    private String category;

    public Expense() {}

    public Expense(
            Long id,
            Double amount,
            String description,
            String category
    ) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public Expense(
            Double amount,
            String description,
            String category
    ) {
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Expense expense = (Expense) obj;
        if (id == null) {
            if (expense.id != null) {
                return false;
            }
        } else if (!id.equals(expense.id)) {
            return false;
        }

        if (amount == null) {
            if (expense.amount != null) {
                return false;
            }
        } else if (!amount.equals(expense.amount)) {
            return false;
        }

        if (description == null) {
            if (expense.description != null) {
                return false;
            }
        } else if (!description.equals(expense.description)) {
            return false;
        }

        if (category == null) {
            if (expense.category != null) {
                return false;
            }
        } else if (!category.equals(expense.category)) {
            return false;
        }

        return true;
    }
}
