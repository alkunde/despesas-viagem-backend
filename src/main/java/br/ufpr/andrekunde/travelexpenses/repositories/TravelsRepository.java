package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelsRepository extends JpaRepository<Travel, Long> {
}
