package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>  {
}
