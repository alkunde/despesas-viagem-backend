package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.Travel;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByUserId(Long id);
}
