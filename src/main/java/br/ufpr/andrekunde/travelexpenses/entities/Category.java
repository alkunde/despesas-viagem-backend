package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ledger_account_id")
    private LedgerAccount ledgerAccount;

    public Category() {}

    public Category(
            Long id,
            String description,
            LedgerAccount ledgerAccount
    ) {
        this.id = id;
        this.description = description;
        this.ledgerAccount = ledgerAccount;
    }

    public Category(
            String description,
            LedgerAccount ledgerAccount
    ) {
        this.description = description;
        this.ledgerAccount = ledgerAccount;
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

    public LedgerAccount getLedgerAccount() {
        return ledgerAccount;
    }

    public void setLedgerAccount(LedgerAccount ledgerAccount) {
        this.ledgerAccount = ledgerAccount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((ledgerAccount == null) ? 0 : ledgerAccount.hashCode());

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

        if (ledgerAccount == null) {
            if (category.ledgerAccount != null) {
                return false;
            }
        } else if (!ledgerAccount.equals(category.ledgerAccount)) {
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
