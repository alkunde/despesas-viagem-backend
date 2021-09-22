package br.ufpr.andrekunde.travelexpenses.repositories;

import br.ufpr.andrekunde.travelexpenses.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
