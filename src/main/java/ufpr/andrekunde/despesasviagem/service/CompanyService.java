package ufpr.andrekunde.despesasviagem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ufpr.andrekunde.despesasviagem.domain.Company;
import ufpr.andrekunde.despesasviagem.exception.BadRequestException;
import ufpr.andrekunde.despesasviagem.mapper.CompanyMapper;
import ufpr.andrekunde.despesasviagem.repository.CompanyRepository;
import ufpr.andrekunde.despesasviagem.requests.company.CompanyPostRequest;
import ufpr.andrekunde.despesasviagem.requests.company.CompanyPutRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    public final CompanyRepository companyRepository;

    public List<Company> listAll() {
        return companyRepository.findAll();
    }

    public Company findByIdOrThrowBadRequestException(Long id) {
        return companyRepository
                .findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Company not found")
                );
    }

    public Company save(CompanyPostRequest companyPostRequest) {
        return companyRepository.save(CompanyMapper.INSTANCE.toCompany(companyPostRequest));
    }

    public void delete(Long id) {
        companyRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CompanyPutRequest companyPutRequest) {
        Company companySaved = findByIdOrThrowBadRequestException(companyPutRequest.getId());

        Company company = CompanyMapper.INSTANCE.toCompany(companyPutRequest);
        company.setId(companySaved.getId());

        companyRepository.save(company);
    }
}
