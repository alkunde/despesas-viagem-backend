package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.Travel;
import br.ufpr.andrekunde.travelexpenses.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelsRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByUser(Users user);

    List<Travel> findByOrigin(String origin);

    List<Travel> findByDestination(String destination);

    List<Travel> findByStatus(String status);
}
