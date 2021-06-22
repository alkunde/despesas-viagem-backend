package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.CostCenter;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long> {
}
