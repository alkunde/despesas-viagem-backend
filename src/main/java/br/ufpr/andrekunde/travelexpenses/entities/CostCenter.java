package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

@Entity
public class CostCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String description;

    public CostCenter() {}

    public CostCenter(
            Long id,
            String code,
            String description
    ) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public CostCenter(
            String code,
            String description
    ) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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

        CostCenter costCenter = (CostCenter) obj;
        if (id == null) {
            return costCenter.id == null;
        } else if (!id.equals(costCenter.id)) {
            return false;
        }

        if (code == null) {
            return costCenter.code == null;
        } else if (!code.equals(costCenter.code)) {
            return false;
        }

        if (description == null) {
            return costCenter.description == null;
        } else if (!description.equals(costCenter.description)) {
            return false;
        }

        return true;
    }
}
