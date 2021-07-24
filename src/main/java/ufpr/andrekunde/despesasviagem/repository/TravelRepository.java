package ufpr.andrekunde.despesasviagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ufpr.andrekunde.despesasviagem.domain.Travel;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByUserId(Long id);

    @Query(value = "SELECT * FROM travel WHERE status = 'em aprovacao'", nativeQuery = true)
    List<Travel> findApprovals();
}
