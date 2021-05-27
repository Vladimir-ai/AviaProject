package service.mapper;

import avia.models.CityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.city.City;

@Mapper
public interface CityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "placeId", source = "placeId")
    @Mapping(target = "placeName", source = "placeName")
    @Mapping(target = "cityId", source = "cityId")
    @Mapping(target = "countryName", source = "countryName")
    CityModel toCityModel(City city);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "placeId", source = "placeId")
    @Mapping(target = "placeName", source = "placeName")
    @Mapping(target = "cityId", source = "cityId")
    @Mapping(target = "countryName", source = "countryName")
    City toCity(CityModel city);
}
