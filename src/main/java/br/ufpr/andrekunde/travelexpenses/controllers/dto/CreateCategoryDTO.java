package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import br.ufpr.andrekunde.travelexpenses.entities.LedgerAccount;

public class CreateCategoryDTO {

    private String description;
    private LedgerAccount ledgerAccount;

    public String getDescription() {
        return description;
    }

    public LedgerAccount getLedgerAccount() {
        return ledgerAccount;
    }
}
