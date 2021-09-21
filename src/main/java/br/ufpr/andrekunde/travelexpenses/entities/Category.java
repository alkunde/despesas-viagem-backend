package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String description;

    public Category() {}

    public Category(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Category(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());

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

        Category category = (Category) obj;
        if (id == null) {
            if (category.id != null) {
                return false;
            }
        } else if (!id.equals(category.id)) {
            return false;
        }

        if (description == null) {
            if (category.description != null) {
                return false;
            }
        } else if (!description.equals(category.description)) {
            return false;
        }

        return true;
    }
}
