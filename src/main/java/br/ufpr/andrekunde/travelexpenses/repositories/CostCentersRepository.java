package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.CostCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostCentersRepository extends JpaRepository<CostCenter, Long> {
}
