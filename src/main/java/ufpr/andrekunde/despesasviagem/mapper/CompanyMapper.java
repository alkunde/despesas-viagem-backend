package ufpr.andrekunde.despesasviagem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ufpr.andrekunde.despesasviagem.domain.Company;
import ufpr.andrekunde.despesasviagem.requests.company.CompanyPostRequest;
import ufpr.andrekunde.despesasviagem.requests.company.CompanyPutRequest;

@Mapper
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company toCompany(CompanyPostRequest companyPostRequest);

    Company toCompany(CompanyPutRequest companyPutRequest);
}
