package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ufpr.andrekunde.despesasviagem.domain.Travel;
import ufpr.andrekunde.despesasviagem.exception.BadRequestException;
import ufpr.andrekunde.despesasviagem.repository.TravelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final TravelRepository travelRepository;

    public List<Travel> listAll() {
        return travelRepository.findAll();
    }

    public Travel findByIdOrThrowBadRequestException(Long id) {
        return travelRepository
                .findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Travel not found")
                );
    }

    public Travel save(Travel travel) {
        return travelRepository.save(travel);
    }

    public void delete(Long id) {
        travelRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(Travel travel) {
        travelRepository.save(travel);
    }
}
