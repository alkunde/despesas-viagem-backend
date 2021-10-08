package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TravelsRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByUser(Users user);

    Optional<Travel> findByOrigin(String origin);

    Optional<Travel> findByDestination(String destination);

    Optional<Travel> findByStatus(String status);
}
