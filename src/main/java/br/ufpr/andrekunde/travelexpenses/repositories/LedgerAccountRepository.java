package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.LedgerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LedgerAccountRepository extends JpaRepository<LedgerAccount, Long> {

    Optional<LedgerAccount> findByCode(String code);
}
