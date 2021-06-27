package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufpr.andrekunde.despesasviagem.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
