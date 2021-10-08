package br.ufpr.andrekunde.travelexpenses.controllers;

import br.ufpr.andrekunde.travelexpenses.controllers.dto.CreateLedgerAccountDTO;
import br.ufpr.andrekunde.travelexpenses.entities.LedgerAccount;
import br.ufpr.andrekunde.travelexpenses.repositories.LedgerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ledger_accounts")
public class LedgerAccountsController {

    @Autowired
    private LedgerAccountRepository repository;

    @GetMapping
    public ResponseEntity<List<LedgerAccount>> list() {
        return ResponseEntity.ok(repository.findAll(Sort.by(Sort.Direction.ASC, "description")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LedgerAccount> find(@PathVariable Long id) {
        Optional<LedgerAccount> ledgerAccount = repository.findById(id);

        if (!ledgerAccount.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ledgerAccount.get());
    }

    @PostMapping
    public ResponseEntity<LedgerAccount> create(@RequestBody CreateLedgerAccountDTO createLedgerAccountDTO) {
        Optional<LedgerAccount> ledgerAccount = repository.findByCode(createLedgerAccountDTO.getCode());

        if (ledgerAccount.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        LedgerAccount newAccount = new LedgerAccount(
                createLedgerAccountDTO.getCode(),
                createLedgerAccountDTO.getDescription()
        );

        repository.save(newAccount);

        return ResponseEntity.ok(newAccount);
    }
}
