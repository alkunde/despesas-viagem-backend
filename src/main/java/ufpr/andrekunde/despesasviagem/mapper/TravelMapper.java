package ufpr.andrekunde.despesasviagem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ufpr.andrekunde.despesasviagem.domain.Travel;
import ufpr.andrekunde.despesasviagem.requests.travel.TravelPostRequest;

@Mapper
public interface TravelMapper {

    TravelMapper INSTANCE = Mappers.getMapper(TravelMapper.class);

    Travel toTravel(TravelPostRequest travelPostRequest);

    //Travel toTravel(TravelPutRequest travelPutRequest);
}
