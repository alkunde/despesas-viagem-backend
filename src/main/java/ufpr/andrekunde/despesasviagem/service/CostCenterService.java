package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ufpr.andrekunde.despesasviagem.domain.CostCenter;
import ufpr.andrekunde.despesasviagem.exception.BadRequestException;
import ufpr.andrekunde.despesasviagem.repository.CostCenterRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CostCenterService {

    public final CostCenterRepository costCenterRepository;

    public List<CostCenter> listAll() {
        return costCenterRepository.findAll();
    }

    public CostCenter findByIdOrThrowBadRequestException(Long id) {
        return costCenterRepository
                .findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Cost center not found")
                );
    }

    public CostCenter save(CostCenter costCenter) {
//        CostCenter costCenter = CostCenterMapper.INSTANCE.toCostCenter(costCenterPostRequest);
        return costCenterRepository.save(costCenter);
    }

    public void delete(Long id) {
        costCenterRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CostCenter costCenter) {
//        CostCenter costCenterSaved = findByIdOrThrowBadRequestException(costCenterPutRequest.getId());

//        CostCenter costCenter = CostCenterMapper.INSTANCE.toCostCenter(costCenterPutRequest);
//        costCenter.setId(costCenterSaved.getId());
        costCenterRepository.save(costCenter);
    }
}
