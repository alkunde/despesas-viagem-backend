package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelsRepository extends JpaRepository<Travel, Long> {

    Optional<Travel> findByOrigin(String origin);

    Optional<Travel> findByDestination(String destination);

    Optional<Travel> findByStatus(String status);
}
