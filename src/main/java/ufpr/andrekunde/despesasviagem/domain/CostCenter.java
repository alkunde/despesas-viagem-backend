package ufpr.andrekunde.despesasviagem.domain;

import javax.persistence.*;

@Entity
public class CostCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public CostCenter() {
    }

    public CostCenter(
            Long id,
            String code,
            String description,
            Company company
    ) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
