package service.mapper;

import avia.models.RecentCityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.RecentCity;

@Mapper
public interface RecentCityMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "city", source = "city")
    RecentCityModel toRecentCityModel(RecentCity purchase);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "city", source = "city")
    RecentCity toRecentCity(RecentCityModel purchase);
}
