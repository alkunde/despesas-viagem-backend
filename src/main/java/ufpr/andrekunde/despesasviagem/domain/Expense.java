package ufpr.andrekunde.despesasviagem.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date expenseDate;
    private double amount;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;

    public Expense() {
    }

    public Expense(
            Long id,
            Date expenseDate,
            double amount,
            String description,
            Category category,
            User user
    ) {
        this.id = id;
        this.expenseDate = expenseDate;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.user = user;
    }

    public Expense(
            Long id,
            Date expenseDate,
            double amount,
            String description,
            Category category,
            User user,
            Travel travel
    ) {
        this(id, expenseDate, amount, description, category, user);

        this.travel = travel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
