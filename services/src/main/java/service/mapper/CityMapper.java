package service.mapper;

import avia.models.CityModel;
import avia.models.RecentCityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.RecentCity;
import service.models.city.City;
import service.models.flight.Place;

import java.util.List;
import java.util.stream.Collectors;

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

//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "placeId", source = "placeId")
//    @Mapping(target = "placeName", source = "placeName")
//    @Mapping(target = "cityId", source = "city.IataCode")
//    @Mapping(target = "countryName", source = "countryName")
//    City toCity(Place city, String placeName);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "city", source = "city")
    RecentCityModel toRecentCityModel(RecentCity purchase);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "city", source = "city")
    RecentCity toRecentCity(RecentCityModel purchase);

    @Mapping(target = "city", source = "city")
    @Mapping(target = "userId", source = "userId")
    RecentCityModel toRecentCityModel(City city, String userId);

    default List<RecentCity> toListRecentCity(List<RecentCityModel> list) {
        return list
                .stream()
                .map(this::toRecentCity)
                .collect(Collectors.toList());
    }
}
