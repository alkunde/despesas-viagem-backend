package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ufpr.andrekunde.despesasviagem.domain.Travel;
import ufpr.andrekunde.despesasviagem.repository.TravelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApprovalService {

    public final TravelRepository travelRepository;

    public List<Travel> listAll() {
        return travelRepository.findApprovals();
    }
}
