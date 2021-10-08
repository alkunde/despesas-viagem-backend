package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostCentersRepository extends JpaRepository<CostCenter, Long> {

    Optional<CostCenter> findByCode(String code);
}
