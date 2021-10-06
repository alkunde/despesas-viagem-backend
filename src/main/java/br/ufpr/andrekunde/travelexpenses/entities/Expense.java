package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 10, scale = 2)
    private Double amount;

    private String description;
    private @Temporal(TemporalType.TIMESTAMP)
    Date expenseDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "travel_id")
    private Travel travel;

    public Expense() {}

    public Expense(
            Double amount,
            String description,
            Date expenseDate,
            Category category,
            Users user
    ) {
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
        this.category = category;
        this.user = user;
    }

    public Expense(
            Double amount,
            String description,
            Date expenseDate,
            Category category,
            Users user,
            Travel travel
    ) {
        this(amount, description, expenseDate, category, user);
        this.travel = travel;
    }

    public Expense(
            Long id,
            Double amount,
            String description,
            Date expenseDate,
            Category category,
            Users user
    ) {
        this(amount, description, expenseDate, category, user);
        this.id = id;
    }

    public Expense(
            Long id,
            Double amount,
            String description,
            Date expenseDate,
            Category category,
            Users user,
            Travel travel
    ) {
        this(id, amount, description, expenseDate, category, user);
        this.travel = travel;
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

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((expenseDate == null) ? 0 : expenseDate.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((travel == null) ? 0 : travel.hashCode());

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

        if (expenseDate == null) {
            if (expense.expenseDate != null) {
                return false;
            }
        } else if (!expenseDate.equals(expense.expenseDate)) {
            return false;
        }

        if (category == null) {
            if (expense.category != null) {
                return false;
            }
        } else if (!category.equals(expense.category)) {
            return false;
        }

        if (user == null) {
            if (expense.user != null) {
                return false;
            }
        } else if (!user.equals(expense.user)) {
            return false;
        }

        if (travel == null) {
            if (expense.travel != null) {
                return false;
            }
        } else if (!travel.equals(expense.travel)) {
            return false;
        }

        return true;
    }
}
