package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ufpr.andrekunde.despesasviagem.domain.Travel;
import ufpr.andrekunde.despesasviagem.exception.BadRequestException;
import ufpr.andrekunde.despesasviagem.mapper.TravelMapper;
import ufpr.andrekunde.despesasviagem.repository.TravelRepository;
import ufpr.andrekunde.despesasviagem.requests.travel.TravelPostRequest;

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

    public Travel save(TravelPostRequest travelPostRequest) {
        Travel travel = TravelMapper.INSTANCE.toTravel(travelPostRequest);

        return travelRepository.save(travel);
    }

    public void delete(Long id) {
        travelRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(Travel travel) {
        travelRepository.save(travel);
    }
}
